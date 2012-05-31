
Examples
========

````
{"value1":1680,"value2":1050}
value1=1680&value2=1050
value1=1680&value2=1050
````

````
{"numArr":[1,2,3]}
numArr%5B%5D=1&numArr%5B%5D=2&numArr%5B%5D=3
numArr[]=1&numArr[]=2&numArr[]=3
````

````
{"objArr":[{"name":"o1","value":"v1"},{"name":"o2","value":"v2"}]}
objArr%5B0%5D%5Bname%5D=o1&objArr%5B0%5D%5Bvalue%5D=v1&objArr%5B1%5D%5Bname%5D=o2&objArr%5B1%5D%5Bvalue%5D=v2
objArr[0][name]=o1&objArr[0][value]=v1&objArr[1][name]=o2&objArr[1][value]=v2
````

````
{"nestedObj":{"provider":"facebook","user_id":1256789,"access_token":"foo"}}
nestedObj%5Bprovider%5D=facebook&nestedObj%5Buser_id%5D=1256789&nestedObj%5Baccess_token%5D=foo
nestedObj[provider]=facebook&nestedObj[user_id]=1256789&nestedObj[access_token]=foo
````

````
{"nestOnce":{"nestTwice":{"value1":123,"value2":456}}}
nestOnce%5BnestTwice%5D%5Bvalue1%5D=123&nestOnce%5BnestTwice%5D%5Bvalue2%5D=456
nestOnce[nestTwice][value1]=123&nestOnce[nestTwice][value2]=456
````

````
{"1":{"value1":123,"value2":456},"15":{"value1":123,"value2":456}}
1%5Bvalue1%5D=123&1%5Bvalue2%5D=456&15%5Bvalue1%5D=123&15%5Bvalue2%5D=456
1[value1]=123&1[value2]=456&15[value1]=123&15[value2]=456
````

````
{"nested":{"1":{"value1":123,"value2":456},"15":{"value1":123,"value2":456}}}
nested%5B1%5D%5Bvalue1%5D=123&nested%5B1%5D%5Bvalue2%5D=456&nested%5B15%5D%5Bvalue1%5D=123&nested%5B15%5D%5Bvalue2%5D=456
nested[1][value1]=123&nested[1][value2]=456&nested[15][value1]=123&nested[15][value2]=456
````

````
{"a":{"b":1,"c":2},"d":[3,4,{"e":5}]}
a%5Bb%5D=1&a%5Bc%5D=2&d%5B%5D=3&d%5B%5D=4&d%5B2%5D%5Be%5D=5
a[b]=1&a[c]=2&d[]=3&d[]=4&d[2][e]=5
````

