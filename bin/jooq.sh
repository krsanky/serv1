#!/bin/sh

BASEDIR=$HOME/JAVA/xyz
JOOQ_LIB=$BASEDIR/jooq-libs

cd $BASEDIR

CP="$JOOQ_LIB/jooq-3.10.4.jar"
CP="$CP:$JOOQ_LIB/jooq-codegen-3.10.4.jar"
CP="$CP:$JOOQ_LIB/jooq-meta-3.10.4.jar"
CP="$CP:$JOOQ_LIB/postgresql-42.1.4.jar"
CP="$CP:." # for find xml confing, needed?

java \
-classpath $CP \
org.jooq.util.GenerationTool \
src/main/resources/jooq-webserver.xml

