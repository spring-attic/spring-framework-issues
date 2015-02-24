### Running

Run with `mvn jetty:run` and visit:

* [http://localhost:8080/test1](http://localhost:8080/test1)
* [http://localhost:8080/test2](http://localhost:8080/test2)
* [http://localhost:8080/test3](http://localhost:8080/test3)
* [http://localhost:8080/test4](http://localhost:8080/test4)

All should redirect to [http://localhost:8080/](http://localhost:8080/) and display 'Hello, World!', but test3 and test4 do not transfer the flash attribute.
