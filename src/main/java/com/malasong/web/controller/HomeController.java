/**
 * 
 */
package com.malasong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Wilson
 */
@Controller
public class HomeController {
	/**
	 * 
	 * @return
	 */
	@RequestMapping(value={"", "/login"})
	public ModelAndView login() {
		
		ModelAndView modelAndView = new ModelAndView("login");

		return modelAndView;
	}

}
