package com.valtech.training.springweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.valtech.training.springweb.vos.LoginVO;

@Controller
public class HelloController {
	
	
	
//	@PostMapping("/login")
//	public ModelAndView login(@ModelAttribute LoginVO login) {
//		boolean valid ="scott".equals(login.getUsername()) && "tiger".equals(login.getPassword());
//		ModelAndView view = new ModelAndView(valid ? "dashboard" : "login");
//		if(valid) {
//			view.addObject("login",login);
//		}else {
//			view.addObject("message", "invalid Username password");
//		}
//		return view;
//	}
	
	//both ways we can write below also
	
	@PostMapping("/login")
	public String handleLoginForm(@ModelAttribute LoginVO login, Model model) {
		if("scott".equals(login.getUsername()) && "tiger".equals(login.getPassword())) {
		   model.addAttribute("login", login);
			return "dashboard";
		}
		 model.addAttribute("message", "Invalid Username Password");
		return "login";
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}
	
	@GetMapping("/hello")
	@ResponseBody
	public String hello() {
		return "HelloSpringWeb ";
	}

}
