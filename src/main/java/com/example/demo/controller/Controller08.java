package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Dto02;
import com.example.demo.domain.Dto03;
import com.example.demo.domain.Dto04;

@Controller
@RequestMapping("sub8")
public class Controller08 {

	// 모델 객체를 직접 만들지 않고서도
	// attr를 전달할 수 있다.
	@RequestMapping("link1")
	public String method1(@ModelAttribute("val") Dto04 dto04) {
		dto04.setAge(11);
		dto04.setName("kwonkwon");

		return "/sub7/link10";
	}

	@RequestMapping("link2")
	public String method2(@ModelAttribute("product") Dto02 dto02) {
		dto02.setCompany("애플");
		dto02.setModel("iPod");
		dto02.setPrice(100000);

		return "/sub8/link2";
	}

	@RequestMapping("link3")
	public void method3(Model model) {
		Dto02 dto02 = new Dto02();
		Dto03 dto03 = new Dto03();

		model.addAttribute("a", dto02);
		model.addAttribute("b", dto03);

	}

	// modelattribute 의 이름을 생략하면
	// 클래스 이름을 loewrCamelCase 이름이 들어가게 된다.
	@RequestMapping("link5")
	public void method4(@ModelAttribute Dto02 dto02,
			@ModelAttribute Dto03 dto03) {

		dto02.setCompany("aaa");
		dto02.setModel("bbb");
		dto02.setPrice(100);
	}

}
