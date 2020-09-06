#!/bin/sh
replace() {
 echo "$1: replace '$3' with '$4' in $2's"
 files=$(find . -not -path "./*/target/*" -not -path "./.idea/*" -iname "$2" -type f | xargs grep -l "$3")
 for file in $files
 do
    sed -i "s/$3/$4/g" "$file"
 done
}

moveDir() {
  mkdir -p $2
  mv $1/* $2
  rm -r $1
}

movePackageSrc() {
  dirFrom=`echo $1 | sed "s/\./\//g"`
  dirTo=`echo $2 | sed "s/\./\//g"`
  dirFromRegex=`echo $dirFrom | sed "s:\/:\\\/:g"`
  dirToRegex=`echo $dirTo | sed "s:\/:\\\/:g"`
  files=$(find . | grep "$dirFrom$" | grep -v "target")
  for file in $files
  do
    file2=`echo $file | sed "s:$dirFromRegex:$dirToRegex:g"`
    moveDir "$file" "$file2"
  done
}


# This should be the only thing needed
co-pilot spring install --config-file co-pilot.info


# This should be a config element in co-pilot.info: "co-pilot-depdendencies" : "flyway-demo"
template_dir=~/.co-pilot/cloud-config/templates/flyway-demo

rsync  --exclude target --exclude *.iml --exclude co-pilot.info --exclude *Application.* --ignore-existing -ahq --progress $template_dir/ webservice/
cd webservice
movePackageSrc "no.copilot.template.demo" "no.copilot.demo"
replace "package refactoring" "*.kt" "no.copilot.template.demo" "no.copilot.demo"
rm -rf src/main/kotlin/no/copilot/template
rm -rf src/test/kotlin/no/copilot/template
cd ..

co-pilot merge pom  --from $template_dir/pom.xml --target webservice
co-pilot merge text --from $template_dir/src/main/resources/application.properties --to webservice/src/main/resources/application.properties
