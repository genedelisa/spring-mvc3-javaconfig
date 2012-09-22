package com.rockhoppertech.mvc.web.controller;

import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {

	private static final Logger logger = LoggerFactory
			.getLogger(IndexController.class);

	@RequestMapping(value = "/")
	public ModelAndView indexPage() {
		logger.debug("IndexController");

		// ModelAndView mav = new ModelAndView("/WEB-INF/views/index.jsp");
		ModelAndView mav = new ModelAndView("index");

		mav.addObject("serverTime", new Date());
		return mav;
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(Locale locale, Model model) {
		return "index";
	}

	@RequestMapping(value = "/welcome", method = RequestMethod.GET)
	public String welcome(Locale locale, Model model) {
		return "welcome";
	}

}
