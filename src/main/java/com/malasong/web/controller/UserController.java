package com.malasong.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.malasong.entity.User;
import com.malasong.service.UserService;

/**
 * 
 * @author shanywei
 *
 */

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping("")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		System.out.println("ni");
		modelAndView.setViewName("user/user-list");
		
		List<User> users = userService.list();
		modelAndView.addObject("users", users);

		return modelAndView;
	}

}
