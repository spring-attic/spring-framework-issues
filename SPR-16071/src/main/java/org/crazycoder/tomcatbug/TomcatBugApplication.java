package org.crazycoder.tomcatbug;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

@SpringBootApplication
public class TomcatBugApplication {

	public static void main(String[] args) {
		SpringApplication.run(TomcatBugApplication.class, args);
	}

    @Controller
    public static class TomcatBugController {
        @RequestMapping("/echo/{text}")
        public StreamingResponseBody getBug(@PathVariable("text") String text) {
            return (out) -> {
                while (true) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    out.write(text.getBytes("UTF-8"));
                    out.write("\n".getBytes());
                    out.flush();
                }
            };
        }
    }
}
