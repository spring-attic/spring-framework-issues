## Demo project for SPR-10655

### Run the project

    mvn clean package cargo:run -Ptomcat8

    curl http://localhost:8080/SPR-10655/static/style.css

Check out that the following logs are in the console:

    INFO [org.springframework.issues.LoggingInterceptor] - <preHandle /SPR-10655/static/style.css>
    INFO [org.springframework.issues.LoggingInterceptor] - <postHandle /SPR-10655/static/style.css>

