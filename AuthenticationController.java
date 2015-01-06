/**
 * 
 */
package com.demo2do.arizona.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demo2do.arizona.entity.security.Principal;
import com.demo2do.core.web.resolver.Secure;

/**
 * @author Downpour
 */
@Controller
public class AuthenticationController {

	private static final Log logger = LogFactory.getLog(AuthenticationController.class);

	/**
	 * Session invalid redirect
	 * 
	 * @return
	 */
	@RequestMapping("/timeout")
	public String timeout(RedirectAttributes redirectAttributes) {

		logger.info("Session timeout ... The system will redirect to login page");
		
		// add a flag into session to display on login page
		redirectAttributes.addFlashAttribute("timeoutErrorMessage", "security.authentication.timeout");
		
		return "redirect:/login";
	}

	/**
	 * 
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value = { "/", "/login" })
	public String login(HttpServletRequest request, HttpSession httpSession, @ModelAttribute("timeoutErrorMessage") String timeoutErrorMessage) {

		// Trying to get AuthenticationException from HttpSession
		AuthenticationException authenticationException = (AuthenticationException) httpSession.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
		
		// when authentication exception is found, setting up error message to display
		if (authenticationException != null) {

			if (logger.isErrorEnabled()) {
				logger.error("Authentication process exception: " + authenticationException.getMessage());
			}			
			
			request.setAttribute("errorMessage", "security.authentication.fail");
			
			if (authenticationException.getCause() instanceof LockedException) {
				request.setAttribute("errorMessage", authenticationException.getMessage());
			}
			
			// remove AuthenticationException from httpSession
			httpSession.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
			
			return "login";
		}

		return "login";
	}

	/**
	 * Execute post login process
	 * 
	 * @return
	 */
	@RequestMapping("/post-login")
	public String postLogin(@Secure Principal principal) {
		
		return "redirect:/home";
	}

}
