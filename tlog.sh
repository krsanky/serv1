#!/bin/sh

cd $HOME/JAVA/tomcat/logs
if [ "${1}HHH" = "-aHHH" ] ; then
    tail -f *
else
    tail -f catalina.out
fi



