#!/usr/bin/env bash

for f in $(find templates -name "pom.xml"); do
	cd $(dirname $f)
	mvn clean install
	cd -
done
