/*
 * $Id$
 */
package org.springframework.web.issues;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Harald Wellmann
 * @version $Rev$ $Date$
 * @since 24.11.2011
 */
@Controller
public class StringMessageController {

    @RequestMapping(value = "/")
    public ResponseEntity<String> sendMessage(HttpServletRequest request,
            HttpServletResponse response) {


        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "text/plain; charset=utf-8");

        String msg = "Die Länge dieses Strings ist größer als im Header angegeben";
        return new ResponseEntity<String>(msg, headers, HttpStatus.OK);
    }
}
