#!/bin/sh

#only needed first time
co-pilot download cli

# This should be the only thing needed
co-pilot spring init --config-file co-pilot.info

# "co-pilot spring install --config-file co-pilot.info.next.level" should replace the bash below 
template_dir=~/.co-pilot/cloud-config/templates/flyway-demo

co-pilot merge template --name flyway-demo --target webservice
co-pilot merge pom  --from $template_dir/pom.xml --target webservice
co-pilot merge text --from $template_dir/src/main/resources/application.properties --to webservice/src/main/resources/application.properties
