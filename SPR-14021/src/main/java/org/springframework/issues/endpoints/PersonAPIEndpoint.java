package org.springframework.issues.endpoints;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

public interface PersonAPIEndpoint {

    @RequestMapping(
            path = "/person/{username}/",
            method = RequestMethod.GET
    )
    String loadUserByUsername(@PathVariable("username") String username);

    @RequestMapping(
            path = "/person/",
            method = RequestMethod.GET
    )
    String listPersons(@RequestParam("pageNum") int pageNum, @RequestParam("pageSize") int pageSize, @RequestParam(value = "query", required = false) String query);

}
