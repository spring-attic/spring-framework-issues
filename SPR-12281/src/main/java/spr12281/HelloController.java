package spr12281;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController
{
	@RequestMapping("/")
	public String get ( HttpServletRequest request )
	{
		return "home";
	}
}
