# CO-PILOT CHEAT SHEET 

## Setup

Example        | Description                  
:--------------------------------|:---------------------------------------------------------------- 
co-pilot profiles                | Shows current profile, if none exists the co-pilot cloud-config will be configured   
co-pilot profiles --cloud-sync   | Clones or pulls the current configured cloud-config             

## Code generation

Example        | Description
:-----------------------------------------------------------------------|:------------------------------------------------------------------
co-pilot examples                                                       | Shows pre-made recipes to kickstart generation of applications and modules
co-pilot examples install --example-name [example-recipe]               | Downloads the pre-made recipe as a co-pilot.json, asks for basic naming customizing and runs the generate-cmd ready for 'mvn install'
co-pilot generate clean                                                 | Cleans the newly generated code except co-pilot.json, typically because you want to change someting in co-pilot.json and re-generate
co-pilot generate                                                       | Generates code as specified by a co-pilot.json in the current directory
[co-pilot-doc](https://devdimensionlab.github.io/configuration/project) | Example co-pilot.json


 
