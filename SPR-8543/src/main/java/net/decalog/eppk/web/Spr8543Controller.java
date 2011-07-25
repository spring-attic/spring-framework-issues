package net.decalog.eppk.web;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rule_sets")
public class Spr8543Controller {
	
    @RequestMapping(value="/{type}", method=RequestMethod.GET)
    public Map<String, String> hello(@PathVariable("type") String type) {
        if (type.endsWith(".json")) {
            throw new RuntimeException("WEBMVC strange behavior");
        }
        return success("Hello " + type);
    }
    
    @RequestMapping(value="/{id}", method=RequestMethod.DELETE)
    public Map<String, String> bye(@PathVariable("id") String id) {
        if (id.endsWith(".json")) {
            throw new RuntimeException("WEBMVC strange behavior");
        }
        return success("Bye " + id);
    }

    private Map<String, String> success(Object res) {
        HashMap<String, String> res_ = new HashMap<String, String>();
        res_.put("res", res.toString());
        return res_;
    }

}
