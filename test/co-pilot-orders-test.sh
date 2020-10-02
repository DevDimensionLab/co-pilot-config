#!/usr/bin/env bash

set -euo pipefail
shopt -s inherit_errexit

for f in $(find test -name "co-pilot.json"); do
	dir=$(dirname $f)
	pom="$dir/pom.xml"
	if [[ ! -f "$pom" ]]; then # only folders which does NOT contain pom.xml
		co-pilot generate --config-file $f --target "$dir/app"
		cd "$dir/app"
		mvn clean install
		cd -
	fi
done
