if [ $# = 0 ] ; then
	echo "USAGE: $0 s1 s2....sN" 
	echo " e.g.: $0 s1 s2 s3" 
	exit 1; 
fi

for((i=1;i<=$#;++i))
do
	arg="$(eval echo "\$$i")";
	url="http://xxxx.com/resources/server/$arg.tar.gz";
	wget $url;
done
