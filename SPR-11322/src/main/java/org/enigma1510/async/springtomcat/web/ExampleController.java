package org.enigma1510.async.springtomcat.web;

import static reactor.event.selector.Selectors.$;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

import reactor.core.Environment;
import reactor.core.Reactor;
import reactor.core.spec.Reactors;
import reactor.event.Event;
import reactor.function.Consumer;

@RequestMapping("/example")
@Controller
public class ExampleController {
	public Logger log = Logger.getLogger(getClass());

	private Environment environment;
	private Reactor defaultEventLoopReactor;

	@PostConstruct
	public void init() {
		environment = new Environment();
		defaultEventLoopReactor = Reactors.reactor().env(environment).dispatcher(Environment.EVENT_LOOP).get();

		defaultEventLoopReactor.on($("request"),
				new Consumer<Event<RequestContext>>() {

					@Override
					public void accept(Event<RequestContext> event) {
						RequestContext context = event.getData();
						DeferredResult<ExampleResponse> deferredResult = context.deferredResult;
						HttpServletResponse servletResponse = context.servletResponse;

						ExampleResponse exampleResponse = new ExampleResponse();
						exampleResponse.setMessage( "success");
						exampleResponse.setStatus( "OK");
						
						log.info("setting response status");
						servletResponse.setStatus( HttpServletResponse.SC_BAD_REQUEST);
						
						log.info("setting result.");
						deferredResult.setResult( exampleResponse);
					}
				});
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public DeferredResult<ExampleResponse> deferredResultExample( HttpServletResponse servletResponse) {
		log.info("controller method invoked");

		DeferredResult<ExampleResponse> deferredResult = new DeferredResult<ExampleResponse>( 2000l);

		RequestContext context = new RequestContext();
		context.deferredResult = deferredResult;
		context.servletResponse = servletResponse;
		
		log.debug("controller method sending event with deferredResult");
		defaultEventLoopReactor.notify("request", Event.wrap(context));

		log.debug("controller method returning deferredResult");
		return deferredResult;
	}
	
	private class RequestContext {
		private DeferredResult<ExampleResponse> deferredResult;
		private HttpServletResponse servletResponse;
	}

}
