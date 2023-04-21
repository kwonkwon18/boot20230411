package com.example.demo.controller;

import java.util.List;

import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dto07;
import com.example.demo.domain.Employee;
import com.example.demo.mapper.Mapper02;

@Controller
@RequestMapping("sub21")
public class Controller21 {

	@Autowired
	private Mapper02 mapper;

	@RequestMapping("link1")
	public void method1() {

		String sql = """
				select customername form Customers
				""";

		List<String> list = mapper.sql1();
		
		list.forEach(System.out::println);

		/*
		 * List<String> list = new ArrayList<>();
		 * 
		 * 
		 * ResultSet rs = st.executeQuery(sql); while (rs.next()) {
		 * list.add(rs.getString(1));
		 */
	}
	
	
	// 경로 : /sub21/link2
	// 모든 직원의 lastname 출력
	@RequestMapping("link2")
	public void method2() {
		List<String> lastname = mapper.sql2();
		
		for(String name : lastname) {
			System.out.println(name);
		}
	}
	
	@RequestMapping("link3")
	public void method3(){
		
		List<Employee> em = mapper.sql3();
		
		em.forEach(System.out::println);
	}
	
	@RequestMapping("link4")
	public void method4() {
		List<Dto07> list = mapper.sql4();
		list.forEach(System.out::println);
	}
	
	@RequestMapping("link5")
	public void method5(@RequestParam("cid") int cid) {
		List<String> names = mapper.sql5(cid);
		names.forEach(e -> System.out.println(e));
	}
	
	// /sub21/link6?ct=uk
	// /sub21/link6?ct=canada
	
	@RequestMapping("link6")
	public void method6(@RequestParam("ct") String country) {
		List<String> list = mapper.sql6(country);
		list.forEach(e -> System.out.println(e));
	}
	
	@RequestMapping("link7")
	public void method7(Integer id) {
		List<Dto07> list = mapper.sql7(id);
		list.forEach(e -> System.out.println(e));
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
