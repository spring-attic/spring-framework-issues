# Reproductible problem with Spring 5 RC2 WebFlux and ServerResponse

## Problem description

Using WebFlux in reactive way, I was expecting this king of thing will work but I always get a 406 status ('Not Acceptable').

```java
	@GetMapping(path = "/bug", produces = "text/html; charset=utf-8")
	@ResponseBody
	public Mono<ServerResponse> getTest() {

		return ServerResponse.ok().body(Mono.just("<html><body><p>This should work</p></body></html>"), String.class);
	}
```
The use of ServerResponse is a way to have a better control on http status and content response in case of error or empty  observable (ex : 404 if ```Mono.empty()``` is returned)

After a deep search I found that the AbstractMessageWriterResultHandler (~ line 112) never find appropriate HttpMessageWriter able to write element of ```ServerResponse``` type.

Is it a bug or do I miss something ?

## How to reproduce

 1. Clone the projet 
```
https://github.com/spring-projects/spring-framework-issues.git
cd ./spring-framework-issues/SPR-15673
```

 2. Compile the project using maven
```
mvn clean package
```
 3. Run the project

```
java -jar target/SPR-15673-0.0.1-SNAPSHOT.jar
```

 4. Test the reproductible case

```
curl -D- http://localhost:8181/bug
```
You will get a 406 status code 'Not Acceptable'

```
HTTP/1.1 406 Not Acceptable
content-length: 0
```