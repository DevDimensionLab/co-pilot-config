#!/usr/bin/env bash

for f in $(find test -name "co-pilot.json"); do
	dir=$(dirname $f)
	pom="$dir/pom.xml"
	if [[ ! -f "$pom" ]]; then # only folders which does NOT contain pom.xml
		co-pilot spring init --config-file $f --target "$dir/app"
	fi
done
