/**
 * 
 */
package com.malasong.web.controller;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Wilson
 */
@Controller
public class MailController {
	/**
	 * 
	 * @return
	 */
	@RequestMapping("/mail")
	public String mail() {
		return "mail/sendmail";
	}

	@RequestMapping(value="/mail", method=RequestMethod.POST)
	public String sendMail(@RequestParam("content") String content, @RequestParam("from") String from, @RequestParam("to") String to) throws MessagingException {

		JavaMailSenderImpl sender = new JavaMailSenderImpl();
		sender.setHost("mail.bjtu.edu.cn");
		sender.setUsername("10301077");
		sender.setPassword("983wsy334");

		MimeMessage message = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);
		helper.setFrom(from);
		helper.setTo(to);
		helper.setText(content);
		sender.send(message);
		
		return "mail/sendmail";
	}
}
