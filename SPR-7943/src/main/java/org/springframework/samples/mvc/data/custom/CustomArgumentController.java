package org.springframework.samples.mvc.data.custom;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;
import org.springframework.web.servlet.mvc.method.annotation.support.ServletWebArgumentResolverAdapter;

@Controller
public class CustomArgumentController {

	// request related
	
	@Autowired
	public CustomArgumentController(RequestMappingHandlerAdapter controllerInvoker) {
		WebArgumentResolver argResolver = new WebArgumentResolver() {
			public Object resolveArgument(MethodParameter param, NativeWebRequest request) throws Exception {
				RequestAttribute attr = param.getParameterAnnotation(RequestAttribute.class);
				if (attr != null) {
					return request.getAttribute(attr.value(), WebRequest.SCOPE_REQUEST);
				} else {
					return WebArgumentResolver.UNRESOLVED;
				}
			}
		};
		List<HandlerMethodArgumentResolver> resolvers = new ArrayList<HandlerMethodArgumentResolver>();
		resolvers.add(new ServletWebArgumentResolverAdapter(argResolver));
		controllerInvoker.setCustomArgumentResolvers(resolvers);
	}
	
	@ModelAttribute
	void beforeInvokingHandlerMethod(HttpServletRequest request) {
		request.setAttribute("foo", "bar");
	}
	
	@RequestMapping(value="/data/custom", method=RequestMethod.GET)
	public @ResponseBody String custom(@RequestAttribute("foo") String foo) {
		return "Got 'foo' request attribute value '" + foo + "'";
	}

}
