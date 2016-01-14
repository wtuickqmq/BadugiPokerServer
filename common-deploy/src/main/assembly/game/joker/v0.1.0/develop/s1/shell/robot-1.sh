#!/bin/sh
#
#该脚本为Linux下启动java程序的通用脚本。即可以作为开机自启动service脚本被调用，
#也可以作为启动java程序的独立脚本来使用。
#
#警告!!!：该脚本stop部分使用系kill命令来强制终止指定的java程序进程。
#在杀死进程前，未作任何条件检查。在某些情况下，如程序正在进行文件或数据库写操作，
#可能会造成数据丢失或数据不完整。如果必须要考虑到这类情况，则需要改写此脚本，
#增加在执行kill命令前的一系列检查。
# 
###################################
# 以下这些注释设置可以被chkconfig命令读取 
# chkconfig: - 99 50 
# description: Java程序启动脚本 
# processname: test 
# config: 如果需要的话，可以配置 
################################### 
#
###################################
#环境变量及程序执行参数
#需要根据实际环境以及Java程序名称来修改这些参数
###################################
#JDK所在路径
JAVA_HOME="/usr/local/jdk1.7.0_71/"

#执行程序启动所使用的系统用户，考虑到安全，推荐不使用root帐号
#RUNNING_USER=lion

#服务器标识
SERVER_TAG=s1
#应用程序名
APP_NAME=joker
#jar包名称
JAR_NAME=robot-1
#Java程序所在的目录（classes的上一级目录）
APP_HOME=/app/server/$APP_NAME/$SERVER_TAG/
#日志所在目录
LOG_HOME=/app/logs/$APP_NAME/$SERVER_TAG/$JAR_NAME/
#需要启动的Java主程序
APP_MAIN=$APP_HOME/execute/$JAR_NAME.jar


#不存在日志文件夹则创建
if [ ! -d "$LOG_HOME" ]; then 
  mkdir -p "$LOG_HOME" 
fi

#日志层级
LOG_LEVEL=INFO
#服务器公网地址
SERVER_HOST=192.168.100.12
#JMX监听端口
JXM_PORT=50012
#服务器监听的tcp端口
TCP_PORT=0
#服务器监听的
HTTP_PORT=0
#ROUTE主机
PROXY_HOST=127.0.0.1
#ROUTE端口
PROXY_PORT=20001

#java程序参数
JAVA_PROGRAM_ARGS=""
#游戏日志输出路径
APP_LOG_OUT="$LOG_HOME/app.out.log"
#GC日志输出路径
APP_LOG_GC="$LOG_HOME/app.gc.log"
#执行命令
JAVA_EXECUTE="-jar $APP_MAIN"

#################################################################################
#拼凑完整的classpath参数，包括指定lib目录下所有的jar
#CLASSPATH=$APP_HOME/classes
#for i in /home/server/execute/naruto/libs/*.jar; do
#   CLASSPATH="$CLASSPATH":"$i"
#done
#JAVA_EXECUTE=" -cp $APP_MAIN:$CLASSPATH com.yxpai.game.naruto.NarutoGameServer"
#################################################################################

#java虚拟机启动参数
JAVA_OPTIONS=" -server"
#指定进程运行的内存大小
JAVA_OPTIONS=$JAVA_OPTIONS" -Xms768m -Xmx768m -Xmn256m -XX:ParallelGCThreads=4 -XX:+UseConcMarkSweepGC -XX:+UseParNewGC"
JAVA_OPTIONS=$JAVA_OPTIONS" -XX:+DisableExplicitGC -XX:+HeapDumpOnOutOfMemoryError -XX:+PrintGCDetails -XX:+PrintHeapAtGC -Xloggc:$APP_LOG_GC"
JAVA_OPTIONS=$JAVA_OPTIONS" -XX:+PrintGCTimeStamps -XX:+PrintGCApplicationStoppedTime -XX:+PrintGCApplicationConcurrentTime -XX:+ExplicitGCInvokesConcurrent"
#指定文件字符集
JAVA_OPTIONS=$JAVA_OPTIONS" -Dfile.encoding=UTF-8"
#开启JVM远程监控模式
JAVA_OPTIONS=$JAVA_OPTIONS" -Djava.rmi.server.hostname=$SERVER_HOST"
JAVA_OPTIONS=$JAVA_OPTIONS" -Dcom.sun.management.jmxremote=true"
JAVA_OPTIONS=$JAVA_OPTIONS" -Dcom.sun.management.jmxremote.port=$JXM_PORT"
JAVA_OPTIONS=$JAVA_OPTIONS" -Dcom.sun.management.jmxremote.ssl=false"
JAVA_OPTIONS=$JAVA_OPTIONS" -Dcom.sun.management.jmxremote.authenticate=false"
#启用jconsole模式
JAVA_OPTIONS=$JAVA_OPTIONS" -Djava.awt.headless=true"
#指定log日志输出路径以及输出级别
JAVA_OPTIONS=$JAVA_OPTIONS" -Dlog.dir=$LOG_HOME -Dlog.level=$LOG_LEVEL"
#分配的线程数量
JAVA_OPTIONS=$JAVA_OPTIONS" -Djet.lanes=10"
#指定ROUTE端口
JAVA_OPTIONS=$JAVA_OPTIONS" -Dproxy.host=$PROXY_HOST"
#指定ROUTE端口
JAVA_OPTIONS=$JAVA_OPTIONS" -Dproxy.port=$PROXY_PORT"
#RPC数量
JAVA_OPTIONS=$JAVA_OPTIONS" -Drpc.size=1"
#RPC权重
JAVA_OPTIONS=$JAVA_OPTIONS" -Drpc.weight=7"
#RPC参加balance
JAVA_OPTIONS=$JAVA_OPTIONS" -Drpc.balance=0"
#指定配置数据库的路径
#JAVA_OPTIONS=$JAVA_OPTIONS" -Dconfig.mysql.table=conf_local"
#指定配置文件路径
#JAVA_OPTIONS=$JAVA_OPTIONS" -Dconfig.local.table=$APP_HOME/conf/rpc-1-1.conf"
#socket远程调试模式
#JAVA_OPTIONS=$JAVA_OPTIONS" -Xdebug -Xnoagent -Djava.compiler=NONE -Xrunjdwp:transport=dt_socket,server=y,suspend=n,address=8888"

###################################
#(函数)判断程序是否已启动
#
#说明：
#使用JDK自带的JPS命令及grep命令组合，准确查找pid
#jps 加 l 参数，表示显示java的完整包路径
#使用awk，分割出pid ($1部分)，及Java程序名称($2部分)
###################################
#初始化psid变量（全局）
psid=0
 
checkpid() {
   javaps=`$JAVA_HOME/bin/jps -l | grep $APP_MAIN`
 
   if [ -n "$javaps" ]; then
      psid=`echo $javaps | awk '{print $1}'`
   else
      psid=0
   fi
}
 
###################################
#(函数)启动程序
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则提示程序已启动
#3. 如果程序没有被启动，则执行启动命令行
#4. 启动命令执行后，再次调用checkpid函数
#5. 如果步骤4的结果能够确认程序的pid,则打印[OK]，否则打印[Failed]
#注意：echo -n 表示打印字符后，不换行
#注意: "nohup 某命令 >/dev/null 2>&1 &" 的用法
###################################
start() {
   checkpid
   if [ $psid -ne 0 ]; then
      echo "================================"
      echo "warn: $APP_MAIN already started! (pid=$psid)"
      echo "================================"
   else
      echo -n "Starting $APP_MAIN ..."
      #JAVA_CMD="nohup $JAVA_HOME/bin/java $JAVA_OPTS -classpath $CLASSPATH $APP_MAINCLASS >/dev/null 2>&1 &"
      #su - $RUNNING_USER -c "nohup $JAVA_HOME/bin/java $JAVA_EXECUTE $JAVA_PROGRAM_ARGS > $APP_LOG_OUT 2>&1 &"
      nohup $JAVA_HOME/bin/java $JAVA_OPTIONS $JAVA_EXECUTE $JAVA_PROGRAM_ARGS > $APP_LOG_OUT 2>&1 &
      checkpid
      if [ $psid -ne 0 ]; then
         echo "(pid=$psid) [OK]"
      else
         echo "[Failed]"
      fi
   fi
}
 
###################################
#(函数)停止程序
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则开始执行停止，否则，提示程序未运行
#3. 使用kill -9 pid命令进行强制杀死进程
#4. 执行kill命令行紧接其后，马上查看上一句命令的返回值: $?
#5. 如果步骤4的结果$?等于0,则打印[OK]，否则打印[Failed]
#6. 为了防止java程序被启动多次，这里增加反复检查进程，反复杀死的处理（递归调用stop）。
#注意：echo -n 表示打印字符后，不换行
#注意: 在shell编程中，"$?" 表示上一句命令或者一个函数的返回值
# kill -9  `ps -ef | grep "$APP_MAIN" | grep -v "grep" | awk '{print $2}' `
###################################
stop() {
   checkpid
 
   if [ $psid -ne 0 ]; then
      echo -n "Stopping $APP_MAIN ...(pid=$psid) "
      #su - $RUNNING_USER -c "kill -9 $psid"
      kill -9 $psid
      if [ $? -eq 0 ]; then
         echo "[OK]"
      else
         echo "[Failed]"
      fi
 
      checkpid
      if [ $psid -ne 0 ]; then
         stop
      fi
   else
      echo "================================"
      echo "warn: $APP_MAIN is not running"
      echo "================================"
   fi
}
 
###################################
#(函数)检查程序运行状态
#
#说明：
#1. 首先调用checkpid函数，刷新$psid全局变量
#2. 如果程序已经启动（$psid不等于0），则提示正在运行并表示出pid
#3. 否则，提示程序未运行
###################################
status() {
   checkpid
 
   if [ $psid -ne 0 ];  then
      echo "$APP_MAIN is running! (pid=$psid)"
   else
      echo "$APP_MAIN is not running"
   fi
}
 
###################################
#(函数)打印系统环境参数
###################################
info() {
   echo "System Information:"
   echo "****************************"
   echo `head -n 1 /etc/issue`
   echo `uname -a`
   echo
   echo "JAVA_HOME=$JAVA_HOME"
   echo `$JAVA_HOME/bin/java -version`
   echo
   echo "APP_HOME=$APP_HOME"
   echo "APP_MAIN=$APP_MAIN"
   echo "****************************"
}
 
###################################
#读取脚本的第一个参数($1)，进行判断
#参数取值范围：{start|stop|restart|status|info}
#如参数不在指定范围之内，则打印帮助信息
###################################
case "$1" in
   'start')
      start
      ;;
   'stop')
     stop
     ;;
   'restart')
     stop
     start
     ;;
   'status')
     status
     ;;
   'info')
     info
     ;;
  *)
     echo "Usage: $0 {start|stop|restart|status|info}"
     exit 1
esac
exit 0
