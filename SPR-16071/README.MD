# Reproduction
The bug appears only in Tomcat, using Jetty it is not reproducible

```
Spring Boot v1.5.7.RELEASE
Apache Tomcat 8.5.20
```


```curl -v -N http://localhost:8080/echo/YYYYYYY
 *   Trying ::1...
 * TCP_NODELAY set
 * Connected to localhost (::1) port 8080 (#0)
 > GET /echo/YYYYYYY HTTP/1.1
 > Host: localhost:8080
 > User-Agent: curl/7.54.0
 > Accept: */*
 >
 < HTTP/1.1 200
 < Transfer-Encoding: chunked
 < Date: Sat, 14 Oct 2017 13:12:37 GMT
 <
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 YYYYYYY
 ^C`
```
Calling it again (sometimes it is required to be called several times) shows the following:
```
curl -v -N http://localhost:8080/echo/YYYYYYY                                                                                                                                                                                       130 ↵
*   Trying ::1...
* TCP_NODELAY set
* Connected to localhost (::1) port 8080 (#0)
> GET /echo/YYYYYYY HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.54.0
> Accept: */*
>
YYYYYYY
YYYYYYY


8
YYYYYYY

8
YYYYYYY

^C
```