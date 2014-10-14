Start the project:

    $ mvn package cargo:run -Ptomcat8

Perform the request:

    $ curl -v --data "" http://localhost:8080/SPR-12287/test

Sample log output:

    $ curl -v --data "" http://localhost:8080/SPR-12287/test
    
    * Hostname was NOT found in DNS cache
    *   Trying 127.0.0.1...
    * Connected to localhost (127.0.0.1) port 8080 (#0)
    > POST /SPR-12287/test HTTP/1.1
    > User-Agent: curl/7.35.0
    > Host: localhost:8080
    > Accept: */*
    > Content-Length: 0
    > Content-Type: application/x-www-form-urlencoded
    >
    < HTTP/1.1 200 OK
    * Server Apache-Coyote/1.1 is not blacklisted
    < Server: Apache-Coyote/1.1
    < Content-Length: 0
    < Date: Tue, 14 Oct 2014 18:58:54 GMT
    <
    * Connection #0 to host localhost left intact
