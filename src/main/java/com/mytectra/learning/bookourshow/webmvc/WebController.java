package com.mytectra.learning.bookourshow.webmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {
	
	@RequestMapping("/home")
	public String home() {
		return "index";
	}
	
	@RequestMapping("/home2")
	public ModelAndView home2() {
		ModelAndView mvm = new ModelAndView("index");
		mvm.addObject("name", "Jayaram");
		return mvm;
	}

}
