package com.malasong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author shanywei
 *
 */

@Controller
@RequestMapping("/users")
public class UserController {

	@RequestMapping("")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("ni");
		modelAndView.setViewName("user/user-list");

		return modelAndView;
	}

}
