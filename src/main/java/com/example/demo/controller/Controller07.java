package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Dto01;
import com.example.demo.domain.Dto02;
import com.example.demo.domain.Dto04;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("sub7")
public class Controller07 {

	@RequestMapping("link1")
	public void method1(HttpServletRequest req) {
		System.out.println("메서드 1 일함 ");
		req.setAttribute("myName", "윤대협");
		// /WEB-INF/views/sub7/link1.jsp
	}

	@RequestMapping("link2")
	public String method2(Model model) {
		System.out.println("메서드 2 일함 ");
		model.addAttribute("myName", "채치수");

		return "/sub7/link1";
	}

	@RequestMapping("link3")
	public String method3(Model model) {
		// 두번째 파라미터 오브젝트 타입이다.
		model.addAttribute("address", "망원동");
		return "/sub7/link3";
	}

//	@RequestMapping("link3")
//	public String method3(Model model) {
//		model.addAttribute("address" , "상암동");
//		return null;
//	}

//	@RequestMapping("link3")
//	public void method3(Model model) {
//		model.addAttribute("address", "성산동");
//	}

	@RequestMapping("link4")
	public void method4(Model model) {
		model.addAttribute("list", List.of("java", "spring"));
	}

	@RequestMapping("link5")
	public void method5(Model model) {
		model.addAttribute("myMap", Map.of("address", "망원동",
				"age", 29,
				"email", "jkseo0118@aaa.com"));
	}

	@RequestMapping("link6")
	public void method6(Model model) {
		model.addAttribute("name", "이한나");
		model.addAttribute("job", "매니저");
		model.addAttribute("hobby", List.of("영화", "독서", "자전거"));
	}

	@RequestMapping("link7")
	public void method7(Model model) {
		// age, country, movies
		List<String> list = new ArrayList<>();
		list.add("왕의남자");
		list.add("아바타");
		list.add("슬램덩크");
		list.add("타이타닉");

		model.addAttribute("age", 29);
		model.addAttribute("country", "seoul");
		model.addAttribute("movies", list);

	}

	@RequestMapping("link8")
	public void method8(Model model) {
		Dto01 o1 = new Dto01();
		o1.setAge(40);
		o1.setName("박지성");

		model.addAttribute("player", o1);
	}

	@RequestMapping("link9")
	public void method9(Model model) {
		Dto02 cafe = new Dto02();

		cafe.setCompany("온달만두분식");
		cafe.setModel("꽈배기");
		cafe.setPrice(1000);

		model.addAttribute("value", cafe);
	}

	@RequestMapping("link10")
	public void method10(Model model) {
		Dto04 obj = new Dto04();
		model.addAttribute("val", obj);
		
		obj.setAge(29);
		obj.setName("kwonkwon");

	}

}
