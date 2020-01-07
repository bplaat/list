#!/bin/bash
clear
mkdir classes
if javac -Xlint -d classes $(find src -name "*.java"); then
    jar cfe list.jar ml.bastiaan.list.App -C classes .
    java -jar list.jar
fi
rm -r classes
