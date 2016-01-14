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

for((i=3;i<=$#;++i))
do
	SERVER_TAG="$(eval echo "\$$i")";
	BUILD_TO_PATH=$SERVER_SRC_ROOT/$VERSION/$TARGET/$SERVER_TAG/;	
	OUT_FILE=$PACKAGE_PATH"/lite/lite-"$SERVER_TAG.tar.gz
	tar --exclude=*/libs --exclude=*/excute --exclude=*/.DS_Store --exclude=*/__MACOSX -Pzcvf $OUT_FILE $BUILD_TO_PATH
	echo "save file >>> "$OUT_FILE;
done
