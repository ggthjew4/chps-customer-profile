package com.chc.chps.restful;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


//@Component
//@Path("/hello")
@RestController
public class Endpoint {
	
	@RequestMapping("/")
	public String home() {
		return "Hello World";
	}

//	@GET
//	public String message() {
//		return "Hello";
//	}
}
