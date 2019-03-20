package org.springframework.issues;

import org.junit.Test;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder.on;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    private UriComponentsBuilder baseUri = UriComponentsBuilder.fromHttpUrl("https://example.com");


    /**
     * NG Pattern.
     */
    @Test
    public void testReturnString() {

        MessageRestController controller = on(MessageRestController.class);
        controller.getMessage("MSG0001");
        URI uri = MvcUriComponentsBuilder.relativeTo(baseUri).withMethodCall(controller).build().toUri();

        assertThat(uri, is(URI.create("https://example.com/messages/MSG0001")));
    }


    /**
     * OK Pattern.
     */
    @Test
    public void testReturnStringWithEntity() {

        MessageRestController controller = on(MessageRestController.class);
        controller.getMessageWithEntity("MSG0001");
        URI uri = MvcUriComponentsBuilder.relativeTo(baseUri).withMethodCall(controller).build().toUri();

        assertThat(uri, is(URI.create("https://example.com/messages/MSG0001")));
    }


    @RequestMapping("messages")
    public static class MessageRestController {

        @RequestMapping("{id}")
        public String getMessage(@PathVariable("id") String id) {
            return "dummy message by " + id;
        }

        @RequestMapping("{id}")
        public ResponseEntity<String> getMessageWithEntity(@PathVariable("id") String id) {
            return ResponseEntity.ok("dummy message by " + id);
        }

    }

}
