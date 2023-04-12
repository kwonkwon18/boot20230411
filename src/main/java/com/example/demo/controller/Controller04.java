package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub4")
public class Controller04 {
	// method argument (parameter)

	@RequestMapping("link1")
	public void method01(HttpServletRequest request) {
		// 1. request 수집 가공
		String name = request.getParameter("name");
		String age = request.getParameter("age");

		System.out.println("name : " + name);
		System.out.println("age : " + age);

		// 2. business logic

		// 3. add attribute

		// 4. forward /redirect

	}

	// 경로 : sub4/link2?address=seoul&email=kwon@gmail.com
	// 위 정보를 출력하는 메서드 만들기

	@RequestMapping("link2")
	public void method2(HttpServletRequest request) {
		String address = request.getParameter("address");
		String email = request.getParameter("email");

		System.out.println("address : " + address);
		System.out.println("email : " + email);

	}

	// 경로 : sub4/link3?address=seoul
	@RequestMapping("link3")
	public void method3(@RequestParam("address") String address) {
		System.out.println("address : " + address);
	}

	// 경로 : sub4/link4?age=99
	@RequestMapping("link4")
	public void method4(@RequestParam("age") String age) {
		System.out.println("age : " + age);

		int myage = Integer.parseInt(age);

		System.out.println("int age : " + myage);
	}

	// 경로 : sub4/link5?age=99&name=kwonkwon
	@RequestMapping("link5")
	public void method5(@RequestParam("age") String age, @RequestParam String name) {
		System.out.println("age : " + age);
		System.out.println("name : " + name);
	}

	// 경로 : sub4/link6?score=90
	@RequestMapping("link6")
	// param의 값을 받는데, 원래 String 이지만, 자동 형변환이 가능하다.
	public void method6(@RequestParam("score") int score) {
		System.out.println("score : " + score);
	}

	// 파라미터와 아규먼트의 이름이 같은 경우는 @requestPram의 괄호안에
	// 이름을 생략해도 된다.
	// 경로 : /sub4/link7?email=jkseo0118@aaa.com
	@RequestMapping("link7")
	public void method7(@RequestParam String email) {
		System.out.println(email);
	}

	// 경로 : /sub4/link8?age=10
	@RequestMapping("link8")
	public void method8(@RequestParam int age) {
		System.out.println(age);
	}

	// 경로 : /sub4/link9?address=mangwon
	@RequestMapping("link9")
	public void method9(String address) {
		System.out.println(address);
	}

	// 경로 : /sub4/link10?score=90.7
	@RequestMapping("link10")
	public void method10(double score) {
		System.out.println(score);
	}

}
