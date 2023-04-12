package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 컨트롤러라고 알려주는 어노테이션 
@Controller
public class Controller01 {

	// 어떤 경로로 왔을 때, 이 메서드가 일을 한다.
	@RequestMapping("/sub1/link1")
	public void method01() {
		System.out.println("메서드1 일함 $%$%$%$%$%");
	}

	@RequestMapping("/sub1/link2")
	public void method02() {
		System.out.println("메서드2 일함 $%$%$%$%$%");
	}

	@RequestMapping("/sub1/link3")
	public void method03() {
		for (int i = 0; i < 10; i++) {
			System.out.print(i);
		}
	}

}
