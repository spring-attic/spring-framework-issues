/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.springframework.issues.endpoints.impl;

import org.springframework.issues.endpoints.PersonAPIEndpoint;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author finkel
 */
@RestController
public class PersonAPIEndpointImpl implements PersonAPIEndpoint{

    @Override
    public String loadUserByUsername(String username) {
        return username;
    }

    @Override
    public String listPersons(int pageNum, int pageSize, String query) {
        return "pageNum: "+ pageNum + ", pageSize: " + pageSize + ", query: " + query;
    }
    
}
