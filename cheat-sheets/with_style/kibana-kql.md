
<div style="background-color:rgba(40,44,53); text-align:center; vertical-align: middle; padding:10px 0;">

# KIBANA KQL CHEAT SHEET 

<div style="background-color:rgba(44,50,60); text-align:center; vertical-align: middle; padding:0px">

## Basic Syntax
</div>

| <span style="color:#AB7143">Example</span> | <span style="color:#AB7143">Description</span>      | 
|:-------------------------------------------|:----------------------------------------------------| 
| dark light                                 | Find documents where any field matches any of the words/terms listed. The term must appear as it is in the document, e.g. this query won’t match documents containing the word “darker”. |  
| orange and (dark or light)                 | Use and/or and parentheses to define that multiple terms need to appear. This query would find all documents that have the term “orange” and either “dark” or “light” (or both) in it.                                            |
| color : orange                             | To find values only in specific fields you can put the field name before the value e.g. this query will only find “orange” in the color field.|
| "our planet"                               | Putting quotes around values makes sure they are found in that specific order (“match a phrase”)|
| dark*                                      | You can use the wildcard * to match just parts of a term/word, e.g. this query will find anything beginning with “dark” like “darker”, “darkest”, “darkness”, etc.                          |
| user.address.* : fakestreet                | You can use the * wildcard also for searching over multiple fields in KQL e.g. this query will search “fakestreet” in all fields beginning with “user.address.”|


<div style="background-color:rgba(44,50,60); text-align:center; vertical-align: middle; padding:0px">

## Comparing values
</div>

<span style="color:#AB7143">Example</span> | <span style="color:#AB7143">Description</span>       
:------------------------------------------|:-------------------------------------------------------- 
price >= 42 and price < 100   | Compare numbers or dates.                                                
destination : *        | Find documents in which a specific field exists (i.e. that does have a non null value for that field). 
products:{ name:pencil and price > 10 } | Querying nested fields 
</div>

 