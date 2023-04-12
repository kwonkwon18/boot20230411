package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sub2")
public class Controller02 {

	// 경로 : /sub2/link1
	@RequestMapping("/link1")
	public void method1() {
		System.out.println("/sub2/link1 에서 일하는 메서드");
	}
	
	// 경로 : /sub2/link1
	@RequestMapping("/link2")
	public void method2() {
		System.out.println("/sub2/link2 에서 일하는 메서드");
	}
}
