# SPR-12481

With a default content-type `application/json`

    curl localhost:8080/SPR-12481/
    {"firstName":"Sherlock","lastName":"Holmes"}% 

    curl -H "Accept: application/xml" localhost:8080/SPR-12481/
    <User><firstName>Sherlock</firstName><lastName>Holmes</lastName></User>% 

    curl -H "Accept: application/json" localhost:8080/SPR-12481/
    {"firstName":"Sherlock","lastName":"Holmes"}%             

    curl -H "Accept: */*" localhost:8080/SPR-12481/
    {"firstName":"Sherlock","lastName":"Holmes"}%
