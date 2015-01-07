/**
 * 
 */
package com.malasong.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Wilson
 */
@Controller
public class HomeController {
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/home")
	public String login() {
		return "redirect:/users";
	}

}
