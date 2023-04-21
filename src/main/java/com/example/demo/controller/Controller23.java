package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.mapper.Mapper04;

@Controller
@RequestMapping("sub23")
public class Controller23 {

	
	@Autowired
	private Mapper04 mapper;
	
	@RequestMapping("link1")
	public void method1() {
		int cnt = mapper.sql1();
		System.out.println(cnt + "개 행 삭제됨");
	}
	
	@RequestMapping("link2")
	public void method2(int id) {
		int cnt = mapper.sql2(id);
		System.out.println(cnt + "개 행 삭제됨");
	}
	
	// /sub23/link3?key=7
	// 메서드 만들기
	@RequestMapping("link3")
	public void method3(Integer key) {
		int cnt = mapper.sql3(key);
		System.out.println(cnt + "삭제 되었습니다. ");
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
