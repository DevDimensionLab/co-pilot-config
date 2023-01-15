
<div style="background-color:rgba(40,44,53); text-align:center; vertical-align: middle; padding:10px 0;">

# UNIX FIND CHEAT SHEET 

<div style="background-color:rgba(44,50,60); text-align:center; vertical-align: middle; padding:0px">

## Basic Syntax
</div>

<span style="color:#AB7143">Example</span>   | <span style="color:#AB7143">Description</span>       
:---------------------------------------------|:---------------------------------------------------- 
find . -name foo.txt                         | search under the current dir                          
find . -name "foo.*"                         | wildcard                                            
find . -iname foo                            | find foo, Foo, FOo, FOO, etc.                       
find . -iname foo -type d                    | same thing, but only dirs                           
find . -iname foo -type f                    | same thing, but only files

<div style="background-color:rgba(44,50,60); text-align:center; vertical-align: middle; padding:0px">

## Find  by text in the file
</div>

<span style="color:#AB7143">Example</span> | <span style="color:#AB7143">Description</span>       
:------------------------------------------|:-------------------------------------------------------- 
find . -type f -name "*.java" -exec grep -l StringBuffer {} \;   | find StringBuffer in all *.java files                                                
find . -type f -name "*.java" -exec grep -il string {} \;        | ignore case with -i option 
find . -type f -name "*.scala" -exec grep -B5 -A10 'null' {} \;  | 5 lines before, 10 lines after grep matches
</div>

 