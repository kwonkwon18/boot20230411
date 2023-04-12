package com.example.demo.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("sub6")
public class Controller06 {

	// 링크1에서 링크2로 포워드 하고 싶다.

	@RequestMapping("link1")
	public String method1() {
		System.out.println("link1 메소드 일함");
		return "forward:/sub6/link2";
	}

	@RequestMapping("link2")
	public void method2() {
		System.out.println("link2 메소드 일함");
	}

	// 경로 : /sub6/link3
	// method3 작성
	// forward /sub6/link2
	@RequestMapping("link3")
	public String method3() {
		System.out.println("link3 메소드 일함");
		// 1
		// 2
		// 3
		// 4 forward
		return "forward:/sub6/link2";
	}

	@RequestMapping("link4")
	public void method4(HttpServletRequest req, HttpServletResponse res)
			throws Exception {

		System.out.println("link4 에서 일함");

		String view = "/WEB-INF/views/abc.jsp";
		req.getRequestDispatcher(view).forward(req, res);
	}

	@RequestMapping("link5")
	public String method5() {

		System.out.println("link5 에서 일함");

		return "forward:/WEB-INF/views/abc.jsp";
	}

	@RequestMapping("link6")
	public String method6() {
		System.out.println("link6  에서 일함");
		return "abc";
	}

	// 경로 : /sub6/link7
	// method7 작성
	// forward /WEB-INF/views/def.jsp
	@RequestMapping("link7")
	public String method7() {
		System.out.println("link 7 일함.");

		return "def";

		/*
		 * request.getRequestDispatcher("/WEB-INF/views/def.jsp") .forward(request,
		 * response);
		 */
	}

	// 경로 : /sub6/link8
	@RequestMapping("link8")
	public String method8() {
		System.out.println("8번 메소드 일함");
		// default view name : /sub6/link8
		return "/sub6/link8";
	}

	// 경로 : /sub6/link9
	@RequestMapping("link9")
	public void method9() {
		System.out.println("9번 메소드 일함");
		// default view name : /sub6/link9
	}

	@RequestMapping("link10")
	public String method10() {
		System.out.println("10번 메서드 일함 ");
		return null; // forward default view name
	}

	// 경로 : /sub6/link11
	// method11 작성
	// /WEB-INF/views/sub6/link11.jsp로 포워드

	@RequestMapping("link11")
////리턴타입 : void
//	public void method11() {
//		System.out.println("메서드 11 일함");
//	}

////	리턴타입 : String 이며 리턴으로 null 사용 
//	public String method11() {
//		System.out.println("메서드 11 일함");
//		return null; 
//	}

//	리턴타입 : String 이고 경로를 명시해서 작성 
	public String method11() {
		System.out.println("메서드 11 일함");
		return "/sub6/link11";
	}

	// 경로 : /sub6/link12?name=kwon&age=33
	// method12로 작성
	// 1. request parameter 수집/가공
	// 2. business logic (생략)
	// 3. add attribute (생략)
	// 4. /WEB-INF/views/sub6/link12/jsp로 포워드

	@RequestMapping("link12")
	public void method12(String name, int age) {
		System.out.println("메서드 12 일함 ");
		System.out.println(name + " " + age);
	}

}
