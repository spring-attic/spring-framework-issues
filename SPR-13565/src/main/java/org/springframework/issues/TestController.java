package org.springframework.issues;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Brian Clozel
 */
@RestController
public class TestController {

    @RequestMapping("/")
    public ResponseEntity<String> test() {
        return ResponseEntity.ok("test");
    }
}
