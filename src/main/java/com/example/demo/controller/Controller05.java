package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("sub5")
public class Controller05 {

	// 경로 : /sub5/link1?name=윤대협&age=33.3&score=40
	@RequestMapping("link1")
	public void method1(@RequestParam String name,
			@RequestParam double age,
			@RequestParam int score) {
		System.out.println(name + " : " + score + " , " + age);
	}

	// 경로 : /sub5/link2?address=seoul&height=170.7&width=39.1
	@RequestMapping("link2")
	public void method2(String address, double height, double width) {
		System.out.println(address);
		System.out.println(height);
		System.out.println(width);
	}

	// 1. request param 얻기 / 가공==> 잘 작성하면 스프링이 해준다.

	// 2. business logic 실행

	// 3. add attribute

	// 4. forward / redirect
}
