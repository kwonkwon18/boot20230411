package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Dto02;
import com.example.demo.domain.Dto03;
import com.example.demo.domain.Dto04;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub9")
public class Controller09 {

	@RequestMapping("link1")
	public String method1(HttpServletRequest req, Model model) {

		// 1. request 꺼내기, 가공
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));

		// 2. 비즈니스 로직

		// 3. add attribute
		Dto04 obj = new Dto04();
		obj.setAge(age);
		obj.setName(name);

		model.addAttribute("value", obj);
		// 4. forward

		return "/sub9/link1";
	}
	
	// /sub9/link2?name=kwon&age=29
	@RequestMapping("link2")
	public String method2(@ModelAttribute("value") Dto04 dto04) {
		// @modelAttribute("value") 를 통해서
		// attribute에 value 라는 이름의 attr를 넣고 
		// 그 attr의 값은 뒤의 dto 를 따르되, 쿼리스트링에 적혀진 것에 의한다.
		// 쿼리스트링에 적힌 value 를 찾아서 들어간다. 
		return "/sub9/link1";
	}
	
//	@RequestMapping("link3")
//	public void method3(@ModelAttribute("attr") Dto03 dto03) {
//		// 1. request param 수집/ 가공
//		// Dto03 객체 만듦
//		// name 요청 파라미터를 위 객체에 셋팅
//		// age 요청 파라미터를 위 객체에 셋팅 
//		
//		// 3. add attribute 추가
//		// 위 객체를 attr 이름으로 model 추가
//		
//		// 4. forward / redirect
//		// /WEB-INF/sub9/link3.jsp 로 포워드 
//	}
	
	@RequestMapping("link4")
	public void method4(Dto04 dto04) {
		// 1. request param 수집/ 가공
		// Dto03 객체 만듦
		// name 요청 파라미터를 위 객체에 셋팅
		// age 요청 파라미터를 위 객체에 셋팅 
		
		// 3. add attribute 추가
		// 위 객체를 dto04 이름으로 model 추가
		
		// 4. forward / redirect
		// /WEB-INF/sub9/link4.jsp 로 포워드 
	}
	
	// 쿼리스트링 : /sub9/link5?model=아반떼&company=현대&price=1000
	@RequestMapping("link5")
	public void method5(Dto02 dto02) {
		// 1. 쿼리스트링 작성
		// 2. jsp 작성
		// dto property 작성
	}
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
