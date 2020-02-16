package com.example.demo.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@org.springframework.stereotype.Controller
public class Controller {

	@GetMapping("/list")
	public String mvc(Model model)
	{
		model.addAttribute("message", "hello");
		return "Home";
	}
}
