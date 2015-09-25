package org.springframework.issues;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

@Controller
public class SseController {

	private static Logger logger = LoggerFactory.getLogger(SseController.class);


	@RequestMapping(path = "/sse", method = RequestMethod.GET)
	public SseEmitter getEvents() {

		SseEmitter emitter = new SseEmitter();

//		emitter.onTimeout(new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("hello timeout");
//				emitter.complete();
//			}
//		});

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
			try {
				emitter.send(SseEmitter.event().data("Thread writing: " + Thread.currentThread()).name("ping"));
			}
			catch (Throwable e) {
				logger.error("In catch: {}", e.getMessage());
			}

		} , 1000, 1000, TimeUnit.MILLISECONDS);

		return emitter;
	}

}
