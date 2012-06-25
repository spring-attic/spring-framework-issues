Examples
========

````
{"value1":1680,"value2":1050}
value1=1680&value2=1050
value1=1680&value2=1050

{"nestedObject":{"provider":"facebook","user_id":1256789,"access_token":"foo"}}
nestedObject%5Bprovider%5D=facebook&nestedObject%5Buser_id%5D=1256789&nestedObject%5Baccess_token%5D=foo
nestedObject[provider]=facebook&nestedObject[user_id]=1256789&nestedObject[access_token]=foo

{"nestOnce":{"nestTwice":{"value1":123,"value2":456}}}
nestOnce%5BnestTwice%5D%5Bvalue1%5D=123&nestOnce%5BnestTwice%5D%5Bvalue2%5D=456
nestOnce[nestTwice][value1]=123&nestOnce[nestTwice][value2]=456

{"arr":[1,2,3]}
arr%5B%5D=1&arr%5B%5D=2&arr%5B%5D=3
arr[]=1&arr[]=2&arr[]=3

{"objArr":[{"name":"o1","value":"v1"},{"name":"o2","value":"v2"}]}
objArr%5B0%5D%5Bname%5D=o1&objArr%5B0%5D%5Bvalue%5D=v1&objArr%5B1%5D%5Bname%5D=o2&objArr%5B1%5D%5Bvalue%5D=v2
objArr[0][name]=o1&objArr[0][value]=v1&objArr[1][name]=o2&objArr[1][value]=v2

{"nestedNumArray1":{"numArr":[1,2,3]},"nestedNumArray2":{"numArr":[1,2,3]}}
nestedNumArray1%5BnumArr%5D%5B%5D=1&nestedNumArray1%5BnumArr%5D%5B%5D=2&nestedNumArray1%5BnumArr%5D%5B%5D=3&nestedNumArray2%5BnumArr%5D%5B%5D=1&nestedNumArray2%5BnumArr%5D%5B%5D=2&nestedNumArray2%5BnumArr%5D%5B%5D=3
nestedNumArray1[numArr][]=1&nestedNumArray1[numArr][]=2&nestedNumArray1[numArr][]=3&nestedNumArray2[numArr][]=1&nestedNumArray2[numArr][]=2&nestedNumArray2[numArr][]=3

{"1":{"value1":123,"value2":456},"15":{"value1":123,"value2":456}}
1%5Bvalue1%5D=123&1%5Bvalue2%5D=456&15%5Bvalue1%5D=123&15%5Bvalue2%5D=456
1[value1]=123&1[value2]=456&15[value1]=123&15[value2]=456

{"nestedObject":{"1":{"value1":123,"value2":456},"15":{"value1":123,"value2":456}}}
nestedObject%5B1%5D%5Bvalue1%5D=123&nestedObject%5B1%5D%5Bvalue2%5D=456&nestedObject%5B15%5D%5Bvalue1%5D=123&nestedObject%5B15%5D%5Bvalue2%5D=456
nestedObject[1][value1]=123&nestedObject[1][value2]=456&nestedObject[15][value1]=123&nestedObject[15][value2]=456

{"nestedObject":{"b":1,"c":2},"nestedMixedArray":[3,4,{"e":5}]}
nestedObject%5Bb%5D=1&nestedObject%5Bc%5D=2&nestedMixedArray%5B%5D=3&nestedMixedArray%5B%5D=4&nestedMixedArray%5B2%5D%5Be%5D=5
nestedObject[b]=1&nestedObject[c]=2&nestedMixedArray[]=3&nestedMixedArray[]=4&nestedMixedArray[2][e]=5
````

