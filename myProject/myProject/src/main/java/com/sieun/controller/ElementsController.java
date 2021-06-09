package com.sieun.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@Controller
@Log
@AllArgsConstructor
@RequestMapping("/sample/*")//URL�� sample�� ������ �������� 
public class ElementsController {

	@GetMapping("/elements")
	public String ele() {
		return "elements";
	}
}
