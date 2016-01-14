#!/bin/sh 
if [ $# -lt 3  ] ; then
	echo "USAGE: $0 version target sid1....sidN" 
	echo " e.g.: $0 v3.1.0 develop s1" 
	exit 1; 
fi
CURRENT_PATH=$(cd "$(dirname "$0")"; pwd)
PARENT_PATH=$(dirname $CURRENT_PATH);
PACKAGE_PATH=$PARENT_PATH"/package/"
SERVER_SRC_ROOT=$(dirname $PARENT_PATH)
VERSION=$1;
TARGET=$2;


function dir_depth() {   
for file in `ls $1`
do       
   if [ -d $1"/"$file ]    
   then
   	  mkdir -p $2"/"$file 	           
      dir_depth $1"/"$file $2"/"$file       
   else   
     cp -f $1"/"$file $2"/"$file       
     echo "copy ==>" $2"/"$file 
   fi   
done
}
 
for((i=3;i<=$#;++i))
do
	SERVER_TAG="$(eval echo "\$$i")";
	BUILD_FROM_PATH=$SERVER_SRC_ROOT/admin/jar/$VERSION/;
	BUILD_TO_PATH=$SERVER_SRC_ROOT/$VERSION/$TARGET/$SERVER_TAG/;
	if [ ! -d "$BUILD_FROM_PATH"]; then
		mkdir -p $BUILD_FROM_PATH
	fi
	if [ ! -d "$BUILD_TO_PATH"]; then
		mkdir -p $BUILD_FROM_PATH
	fi		
	echo "copy from"$BUILD_FROM_PATH" to "$BUILD_TO_PATH;
	dir_depth $BUILD_FROM_PATH $BUILD_TO_PATH
	tar -Pzcvf $PACKAGE_PATH"/full/full-"$SERVER_TAG.tar.gz $BUILD_TO_PATH
done
