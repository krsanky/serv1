#!/bin/sh

DIR1="$HOME/JAVA/serv1"
WAR="build/libs/serv1.war"
URL="http://tomcat:tomcat@localhost:8080/manager/text/deploy?path=/serv1&update=true"

cd $DIR1

gradle war

curl --upload-file $WAR $URL 
#curl -T $WAR $URL


