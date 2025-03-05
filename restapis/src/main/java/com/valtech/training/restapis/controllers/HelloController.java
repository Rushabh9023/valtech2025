package com.valtech.training.restapis.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
//	@RequestMapping(method = RequestMethod.GET,path = "/hello")
	// Shorter way then before
	
	
	// use url as   http://localhost:8080/hello?name=Rushabh
//	@GetMapping("/hello")
//	public String hello(@RequestParam("name") String name) { 
//		return "Hello " + name;
//	}
	
	
//	use url as   http://localhost:8080/hello/Rushabh
//	@GetMapping("/hello/{name}")
//	public String hello(@PathVariable("name") String name) {
//		return "Hello " + name;
//	}
	
	
//	use url as  http://localhost:8080/hello/Rushabh?times=2
	@GetMapping("/hello/{name}")
	public String hello(@PathVariable("name") String name,@RequestParam("times") int times) {
		
		String res = "";
		for(int i = 0; i < times;i++ ) {
			res+=name+" ";
		}
		
		return "Hello " + res;
	}
	

}
