package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Dto09;
import com.example.demo.domain.Dto10;
import com.example.demo.domain.Dto11;
import com.example.demo.domain.Dto12;
import com.example.demo.mapper.Mapper03;

@Controller
@RequestMapping("sub22")
public class Controller22 {

	@Autowired
	private Mapper03 mapper;

	@RequestMapping("link1")
	public void method1() {
		int cnt1 = mapper.sql1(77, "java");
		int cnt2 = mapper.sql1(88, "spring");
		int cnt3 = mapper.sql1(99, "css");

		System.out.println(cnt1);
		System.out.println(cnt2);
		System.out.println(cnt3);
	}

	@RequestMapping("link2")
	public void method2(Double col1, String col2) {
		int count1 = mapper.sql2(col1, col2);
		System.out.println(count1);
	}

	@RequestMapping("link3")
	public void method3() {
		Dto09 dto = new Dto09();
		dto.setProp1(300);
		dto.setProp2("헬로 마이바티스");
		dto.setProp3(33.33);

		int cnt = mapper.sql3(dto);
		System.out.println(cnt);
	}

	@RequestMapping("link4")
	public void method4(Integer age, String name, Double score) {
		Dto10 dto = new Dto10();
		dto.setAge(age);
		dto.setName(name);
		dto.setScore(score);

		int cnt = mapper.sql4(dto);

		System.out.println(cnt);
	}

	// /sub22/link5?age=29&name=park&score=88.8
	@RequestMapping("link5")
	public void method6(@ModelAttribute Dto10 dto) {
		int cnt = mapper.sql4(dto);
		System.out.println(cnt + "개 행 입력");
	}

	// mytable36에 추가될 수 있게 아래 코드수정
	// /sub22/link6?prop1=30&prop2=40&prop3=50
	@RequestMapping("link6")
	public void method7(Dto09 dto) {
		int cnt = mapper.sql3(dto);
		System.out.println(cnt + "개 행 입력됨");
	}

	@RequestMapping("link7")
	public void method8() {
		Dto09 dto1 = new Dto09();
		Dto10 dto2 = new Dto10();
		dto1.setProp1(123);
		dto2.setName("서태웅");
		dto1.setProp3(12.11);
		int cnt = mapper.sql5(dto1, dto2);

		System.out.println(cnt);
	}

	@RequestMapping("link8")
	public void method9() {
		Dto09 dto1 = new Dto09();
		Dto10 dto2 = new Dto10();

		dto1.setProp1(10);
		dto2.setAge(20);
		dto1.setProp2("아아아");
		dto2.setName("권권권");
		dto1.setProp3(3.33);
		dto2.setScore(8.88);

		int cnt = mapper.sql6(dto1, dto2);
		System.out.println(cnt);
	}

	// /sub22/link10?prop2=mybatis&prop3=321
	@RequestMapping("link10")
	public String method10(Dto11 dto) {
		System.out.println("실행 전 : " + dto.getProp1());
		int cnt = mapper.sql7(dto);
		System.out.println(cnt + "행 입력 완료");
		System.out.println("실행 후 : " + dto.getProp1());

		return dto.getProp1() + "번째 파일 입력 완료";
	}

	// sub22/link12?age=40&name=son&score=9.9
	// 요청시 MyTable40 데이터 추가되도록 코드
	// 컨트롤러메서드, 매퍼 메서드 , 자바빈
	// 자바빈의 id 프로퍼티에 자동증가 컬럼값 받을 수 있게
	@RequestMapping("link12")
	public String method11(Dto12 dto) {
		int cnt = mapper.sql8(dto);
		
		return cnt + "개가 생성되었습니다";
	}

}
