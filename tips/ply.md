# PLYBUILD CHEAT SHEET 

## Setup

Example        | Description                  
:--------------------------------|:---------------------------------------------------------------- 
ply profiles                | Shows current profile, if none exists the ply cloud-config will be configured   
ply profiles --cloud-sync   | Clones or pulls the current configured cloud-config             

## Code generation

Example        | Description
:-----------------------------------------------------------------------|:------------------------------------------------------------------
ply examples                                                       | Shows pre-made recipes to kickstart generation of applications and modules
ply examples install --example-name [example-recipe]               | Downloads the pre-made recipe as a ply.json, asks for basic naming customizing and runs the generate-cmd ready for 'mvn install'
ply generate clean                                                 | Cleans the newly generated code except ply.json, typically because you want to change someting in ply.json and re-generate
ply generate                                                       | Generates code as specified by a ply.json in the current directory
[ply-doc](https://devdimensionlab.github.io/configuration/project) | Example ply.json


 
