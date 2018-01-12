#!/bin/sh

WAR="build/libs/serv1.war"
URL="http://tomcat:tomcat@localhost:8080/manager/text/deploy?path=/serv1&update=true"

curl --upload-file $WAR $URL 
#curl -T $WAR $URL


