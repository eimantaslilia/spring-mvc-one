package com.luv2code.springdemo.mvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/hello")
public class HelloWorldController {

	// need a controller method to show the initial form
	@RequestMapping("/showForm")
	public String showForm() {
		return "helloworld-form";
	}
	@RequestMapping("/processForm")
	public String processForm() {
		return "helloworld";
	}
	
	@RequestMapping("/processFormTwo")
	public String letsShoutDude(HttpServletRequest request, Model model) {
		 
		//read the request parameter from html form
		String theName = request.getParameter("studentName");
		//convert that data too all upper case
		theName = theName.toUpperCase();
		
		//create our message
		String result = "Yo! MY MAN " + theName;
		//add that message to the model
		model.addAttribute("message", result);
		
		return "helloworld";
	}
	
	@RequestMapping("/processFormThree")
	public String processFormVersionThree(
			@RequestParam("studentName") String theName,
			Model model) {
	
		theName = theName.toUpperCase();
	
		String result = "Yo! MY bud from V3! " + theName;

		model.addAttribute("message", result);
		
		return "helloworld";
	}
}
