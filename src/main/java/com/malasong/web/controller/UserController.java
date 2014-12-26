package com.malasong.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.malasong.entity.Clazz;
import com.malasong.entity.User;
import com.malasong.service.ClazzService;
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

	@Autowired
	private ClazzService clazzService;


	@RequestMapping("")
	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("user/user-list");
		
		List<User> users = userService.list();
		modelAndView.addObject("users", users);

		return modelAndView;
	}

	@RequestMapping("/create")
	public ModelAndView create() {
		ModelAndView modelAndView = new ModelAndView("user/user-add");

		List<Clazz> clazzes = clazzService.list();
		modelAndView.addObject("clazzes", clazzes);

		return modelAndView;
	}

	@RequestMapping(method=RequestMethod.POST)
	public String onCreate(User user) {
		userService.create(user);
		return "redirect:/users";
	}

	@RequestMapping("/{id}/edit")
	public ModelAndView edit(@PathVariable("id") Long id) {
		ModelAndView modelAndView = new ModelAndView("user/user-edit");

		User user = userService.load(User.class, id);
		List<Clazz> clazzes = clazzService.list();

		modelAndView.addObject("user", user);
		modelAndView.addObject("clazzes", clazzes);

		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method=RequestMethod.PATCH)
	public String onEdit(@PathVariable("id") Long id, User userForm) {
		User user = userService.load(User.class, id);
		userService.edit(user, userForm.getName(), userForm.getYear(), userForm.getClazz());
		return "redirect:/users";
	}

}
