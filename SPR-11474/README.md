To invoke these controller with `curl`, deploy the war in your favorite container (assuming `8080`)

According to the [original description](https://jira.springsource.org/browse/SPR-11474), This
one is supposed to work:

```
curl -X PUT
    \--data {} -H "Content-Type:application/json; charset=utf-8"
    \http://localhost:8080/tag/mmm%C3%A6%C3%A6%C3%B8%C3%A5
```

And this one should not

```
curl -X DELETE
    \-H "Content-Type:text/plain; charset=utf-8"
    \http://localhost:8080/tag/mmm%C3%A6%C3%A6%C3%B8%C3%A5
```
