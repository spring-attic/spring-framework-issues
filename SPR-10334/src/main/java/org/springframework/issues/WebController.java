package org.springframework.issues;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class WebController {

    @RequestMapping(value = "/some.data", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public String getSomeData() {
        return "{\"hello\": \"world\"}";
    }
}
