package com.niit.sandeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	

	@RequestMapping("/")
	public ModelAndView gethomePage() {
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	@RequestMapping("/screenText")
	public ModelAndView getscreenPage() {
		ModelAndView mv = new ModelAndView("screenText");
		return mv;
	}
	@RequestMapping("/sc")
	public ModelAndView sc() {
		ModelAndView mv = new ModelAndView("sc");
		return mv;
	}
	@RequestMapping("/Qtext")
	public ModelAndView nnnn() {
		ModelAndView mv = new ModelAndView("Qtext");
		return mv;
	}
	

}
