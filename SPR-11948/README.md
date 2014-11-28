# SPR-11948

    curl -vvv localhost:8080/SPR-11948/
    > GET /SPR-11948/ HTTP/1.1
    > User-Agent: curl/7.37.1
    > Host: localhost:8080
    > Accept: */*
    >
    < HTTP/1.1 200 OK
    < Server: Apache-Coyote/1.1
    < ETag: "0a2c726be9d6a1c02e8b6e665b70b0e9d"
    < Content-Type: application/xml
    < Content-Length: 74
    < Date: Fri, 28 Nov 2014 09:44:33 GMT
    <
    <?xml version="1.0" encoding="UTF-8" standalone="yes"?><user name="test"/>%