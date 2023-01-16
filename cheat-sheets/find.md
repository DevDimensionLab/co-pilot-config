# UNIX FIND CHEAT SHEET 

## Basic Syntax

Example   | Description       
:---------------------------------------------|:---------------------------------------------------- 
find . -name foo.txt                         | search under the current dir                          
find . -name "foo.*"                         | wildcard                                            
find . -iname foo                            | find foo, Foo, FOo, FOO, etc.                       
find . -iname foo -type d                    | same thing, but only dirs                           
find . -iname foo -type f                    | same thing, but only files

## Find  by text in the file

Example | Description       
:------------------------------------------|:-------------------------------------------------------- 
find . -type f -name "*.java" -exec grep -l StringBuffer {} \;   | find StringBuffer in all *.java files                                                
find . -type f -name "*.java" -exec grep -il string {} \;        | ignore case with -i option 
find . -type f -name "*.scala" -exec grep -B5 -A10 'null' {} \;  | 5 lines before, 10 lines after grep matches

 