package org.springframework.issues;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyController {

	// Note : "code2 " has a white space at the end
	private final static List<String> CODES = Arrays.asList(new String[]{"code1", "code2 ", "code3"});

	@RequestMapping("/")
	public String hello(HttpServletRequest request, Model model, @ModelAttribute("searchCriteria") SearchCriteria searchCriteria) {
		this.logHttpParamValues(request);
		// Depending on the registration of org.springframework.format.support.FormattingConversionServiceFactoryBean in spring/web-conf.xml
		// the single "code2 " will be trimed or not
		System.out.println("codes =>> " + searchCriteria.getCodes());
		model.addAttribute("availableCodes", CODES);
		return "hello";
	}

	private void logHttpParamValues(HttpServletRequest request) {
		System.out.println("Start - print HTTP params");
		for (Map.Entry<String, String[]> entry : request.getParameterMap().entrySet()) {
			System.out.print(entry.getKey() + " = ");
			System.out.println(entry.getValue() == null ? "null" : Arrays.asList(entry.getValue()).toString());
		}
		System.out.println("End - print HTTP params");
	}
}
