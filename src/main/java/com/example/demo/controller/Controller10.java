package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dto04;

@Controller
@RequestMapping("sub10")
public class Controller10 {

	// requestParameter와 model 의 차이
	// requestParam = 기본타입, wrapper 타입, String 타입

	@RequestMapping("link1")
	public void method1(@RequestParam String name) {
		/*
		 * String name = request.getParameter("name") 생략된 부분
		 */
	}

	@RequestMapping("link2")
	public void mothod2(@ModelAttribute Dto04 dto04) {
		/*
		 * Dto04 dto = new Dto04(); dto.setName(request.getParameter("name"));
		 * dto.setAge(request.getParameter("age"));
		 * 
		 * request.setAttribute("dto04", dto);
		 */
	}

	// /sub10/link3?model=ray&price=1000&name=kwon&age=10
	@RequestMapping("link3")
	public void method3(
//			@ModelAttribute("model")
			String model,
//			@ModelAttribute("price")
			double price,
			Dto04 obj) {
		
		 
		System.out.println(model);
		System.out.println(price);
	}
	
	@RequestMapping("link4")
	public void method4() {
		// 1. request param 수집 가공

		// 2. business logic
		// data를 생성, 읽기, 수정, 삭제
		// crud
		
		// 3. add attribute
		
		// 4. forward
	}
	
	
	
	
}
