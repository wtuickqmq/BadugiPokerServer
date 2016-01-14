#!/bin/sh 
if [ $# -lt 4  ] ; then
	echo "USAGE: $0 command version target sid1....sidN" 
	echo " e.g.: $0 status v3.1.0 develop s1" 
	exit 1; 
fi
CURRENT_PATH=$(cd "$(dirname "$0")"; pwd)
PARENT_PATH=$(dirname $CURRENT_PATH);
PACKAGE_PATH=$PARENT_PATH"/package/"
SERVER_SRC_ROOT=$(dirname $PARENT_PATH)
COMMAND=$1;
VERSION=$2;
TARGET=$3;

for((i=4;i<=$#;++i))
do
	SERVER_TAG="$(eval echo "\$$i")";
	BUILD_TO_PATH=$SERVER_SRC_ROOT/$VERSION/$TARGET/$SERVER_TAG/;
	route=$BUILD_TO_PATH/shell/route.sh;
	proxy=$BUILD_TO_PATH/shell/proxy-1.sh;
	logic=$BUILD_TO_PATH/shell/logic-1-1.sh;
	if [ -f "$route" ]; then 
	 	$daemon $COMMAND
	fi
	if [ -f "$proxy" ]; then 
	 	$route $COMMAND
	fi
	if [ -f "$logic" ]; then 
		$rpc $COMMAND
	fi
done
