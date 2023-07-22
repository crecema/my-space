#!/bin/bash
# Build script for the project

mvn clean package -e -U -DskipTests

rm -rf output && mkdir output

cp jarvis.sh output/
mv target/*.jar output/

rm -rf target
