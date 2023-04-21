package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;
import com.example.demo.mapper.Mapper05;

@Controller
@RequestMapping("sub24")
public class Controller24 {

	@Autowired
	private Mapper05 mapper;

	@RequestMapping("link1")
	public void method1() {
		int cnt = mapper.sql1();
		System.out.println(cnt + "개 행 수정됨");
	}

	@RequestMapping("link2")
	public void method2() {
		int cnt = mapper.sql2(6, "마이바티스", 98765);
		System.out.println(cnt + "개 행 변경됨");
	}

	@RequestMapping("link3")
	public void method3() {
		// 10번 고객 이름과 국가가 변경 되도록
		// mapper에 sql3 메소드 작성
		int cnt = mapper.sql3(10, "새로운 고객명", "대한민국");
		System.out.println(cnt + "개 행 변경됨");
	}

	@RequestMapping("link5")
	public void method(Customer customer) {
		int cnt = mapper.sql4(customer);
		System.out.println(cnt + "개 행 수정됨");
	}

	// /sub24/link6?id=9
	@RequestMapping("link6")
	public void method(Integer id, Model model) {
		Customer customer = mapper.sql5(id);
		model.addAttribute("customer", customer);
	}

	// 직원 조회 및 수정 코드 작성
	// 조회 ==> 수정 정보 입력하는 view 단으로 보야함
	@RequestMapping("link7")
	public void method7(Integer id, Model model) {
		Employee em = mapper.sql6(id);
		model.addAttribute("em", em);
	} // ==> 해당 id의 정보를 모두 갖고 있는 em 객체 반환
	
	// 수정
	@RequestMapping("link8")
	public void method7(Employee em) {
		int cnt = mapper.sql7(em);
		System.out.println(cnt);
		
	}
	

}
