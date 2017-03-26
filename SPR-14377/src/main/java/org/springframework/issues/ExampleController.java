package org.springframework.issues;

import static org.apache.commons.lang3.StringUtils.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.HeadersBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller("/example")
@RequestMapping(path = "/example", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.POST, consumes = {
        MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
public class ExampleController
{

    private final static Logger log = LogManager.getLogger(ExampleController.class);

    @RequestMapping(path = "/go", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String go(@RequestBody MultiValueMap<String, String> form, RedirectAttributes redirectAttrs, HttpServletRequest request)
    {
        try
        {
            boolean redirect = false;

            String page = form.getFirst("forward");
            if (isBlank(page))
            {
                redirect = true;
                page = form.getFirst("redirect");
            }
            if (isBlank(page))
                // Non posso fare più nulla
                throw new NullPointerException("Missing both forward and redirect attributes. Where do you like to go, dude?");

            if (!page.startsWith("/"))
                page = "../" + page;

            if (redirect)
            {
                log.debug("Redirecting to: " + page);
                for (String key : form.keySet())
                    redirectAttrs.addFlashAttribute(key, form.getFirst(key));
            }
            else
                log.debug("Forwarding to: " + page);

            return (redirect ? "redirect:" : "forward:") + page;
        }
        catch (Throwable ex)
        {
            log.error(ex);
            throw new RuntimeException(ex);
        }
    }

    //Simplification... it should be a view anyway!
    @RequestMapping("/page")
    public HeadersBuilder<?> page()
    {
        return ResponseEntity.noContent();
    }

}
