package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody
	@RequestMapping(value = "/hello-boot", method = RequestMethod.GET)
	public String dailyStats(@RequestParam String name) {
		return "Hello Spring "+name+" !!! Let's Start from here ";

	}

}