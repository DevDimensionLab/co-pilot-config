#!/bin/sh

#only needed first time
co-pilot download cli

# This should be the only thing needed
co-pilot spring init --config-file co-pilot.info
co-pilot merge template --name flyway-demo --target webservice
