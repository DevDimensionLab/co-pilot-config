#!/usr/bin/env bash

#set -euo pipefail
#shopt -s inherit_errexit

for f in $(find templates -name "pom.xml"); do
	cd $(dirname $f)
	mvn clean install
	cd -
done
