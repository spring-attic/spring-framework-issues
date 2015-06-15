package hello;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    // This responds 406 Not Acceptable even if the client requests with "Accept: */*" header.
    @RequestMapping("/test/{a}")
    public OutputStream test(@PathVariable String a) {
        return new ByteArrayOutputStream();
    }
}
