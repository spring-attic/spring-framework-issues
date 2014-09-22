package test.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class MainController {
	DeferredResult<String> deferredResult;
	
	@RequestMapping("/get_message")
	@ResponseBody
	public DeferredResult<String> mainPage() {
		deferredResult = new DeferredResult<String>(null, "timeout");
		return deferredResult;
	}
	
	@RequestMapping("/send_message")
	@ResponseBody
	public String sendMessage() {
		deferredResult.setResult("message");
		return "sent message";
	}

	@ExceptionHandler
	@ResponseBody
	public String handleException(IllegalStateException ex) {
		return "Handled exception: " + ex.getMessage();
	}
}