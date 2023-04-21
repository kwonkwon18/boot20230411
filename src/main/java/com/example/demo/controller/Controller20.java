package com.example.demo.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Dto05;
import com.example.demo.domain.Dto06;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Supplier;
import com.example.demo.mapper.Mapper01;

@Controller
@RequestMapping("sub20")
public class Controller20 {

	@Autowired
	private Mapper01 mapper;

	@RequestMapping("link1")
	public void method1() {

		String name = mapper.method1();
		System.out.println(name);

		System.out.println(mapper.method2());

		System.out.println(mapper.method3());

	}

	@RequestMapping("link3")
	public void method3() {
		String name = mapper.method4(1);
		System.out.println(name);
	}

	@RequestMapping("link4")
	public void method4(@RequestParam("id") Integer customerId) {
		String name = mapper.method4(customerId);
		System.out.println(name);
	}

	// link5?id=2
	// 2번 직원의 lastName 콘솔에 출력
	@RequestMapping("link5")
	public void method5(
			@RequestParam("id") int id) {
		String name = mapper.method5(id);
		System.out.println(name);
	}

	@RequestMapping("link6")
	public void method6() {
		Integer price = mapper.method6();
		System.out.println(price);

		Double weight = mapper.method7();
		System.out.println(weight);

		LocalDate pub = mapper.method8();
		System.out.println(pub);

		LocalDateTime updated = mapper.method9();
		System.out.println(updated);
	}

	@RequestMapping("link7")
	public void method7() {
		Dto06 res = mapper.method10();
		System.out.println(res);

	}

	@RequestMapping("link8")
	public void method8() {
		Dto05 res = mapper.method11();
		System.out.println(res);
	}
	
	@RequestMapping("link9")
	public void method9() {
		Customer res = mapper.method12();
		System.out.println(res);
	}

	@RequestMapping("link10")
	public void method10(int id) {
		Supplier sup = mapper.method13(id);
		System.out.println(sup);
	}
	
	@RequestMapping("link11")
	public void method14(int id) {
		Employee em = mapper.method14(id);
		System.out.println(em);
	}
	
	
}
