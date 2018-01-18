#!/bin/sh

DIR1="$HOME/JAVA/xyz"
WAR="build/libs/xyz*.war"
URL="http://tomcat:tomcat@localhost:8080/manager/text/deploy?path=/xyz&update=true"

cd $DIR1

gradle war

curl --upload-file $WAR $URL 
#curl -T $WAR $URL


