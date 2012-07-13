package org.springframework.issues;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;










@Controller
public class PortletController {

	
	@Autowired
	@Qualifier("asyncService")
	private AsyncService asyncService;


	
	
	@RequestMapping(value = "/async.mvc")
	public String async(Model model) {

		return "general.definition.async";
	}

	@RequestMapping(value = "/getAsync.mvc")
	public @ResponseBody
	ResultDto getAsync(
			@RequestParam(value = "portalWidth", required = false) String width,
			@RequestParam(value = "targetDiv", required = true) String targetDiv,
			HttpServletRequest request, HttpServletResponse response,
			Model model) {
		 String threadName = Thread.currentThread().getName();
	      
		
		ResultDto dto = new ResultDto();
		try {
			dto = asyncService.findBalanceAsync(targetDiv);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			dto.setContent(e.getMessage());
			dto.setProcessCode(ResultCode.ERROR);
		}

		return dto;
	}
	
}
