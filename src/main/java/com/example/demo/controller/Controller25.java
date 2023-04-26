package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("sub25")
public class Controller25 {

	@RequestMapping(value = "link1", method = RequestMethod.GET)
	public void method1() {
		System.out.println("/sub25/link1 에서 메서드 일함");
	}

	// @RequestMapping(value = "link2", method = RequestMethod.GET)
	@GetMapping("link2")
	public void method2() {
		System.out.println("/sub25/link2 에서 메서드 일함");
	}

	// @RequestMapping(value = "link2", method = RequestMethod.POST)
	@PostMapping("link3")
	public void method3() {
		System.out.println("/sub25/link3 에서 메서드 일함");
	}

	// 요청 경로의 일부를 변수로 담아서 쓸 수 있다.
	// PathVariable
	@GetMapping("link4/{var1}")
	public void method4(@PathVariable("var1") String p1) {
		System.out.println("var 1 : " + p1);
	}

	@GetMapping("link5/{id}/{age}")
	public void method5(@PathVariable("id") String id,
			@PathVariable("age") int age) {
		System.out.println(id + " " + age);
	}

	// sub25/link6/id/3/name/som
	@GetMapping("link6/id/{var1}/name/{var2}")
	public void method6(@PathVariable("var1") String id,
			@PathVariable("var2") String name) {
		System.out.println(id + " " + name);
	}
	
	@GetMapping("link7")
	public String method7() {
		
		return "hello"; // WEB-INF/views/hello.jsp
		
	}
	
//	@GetMapping("link7")
//	public String method8(HttpServletResponse res) {
//		res.sendRedirect(location);
//	}
	
	// 리다이렉트
	// String 리턴 타입으로 하고 redirect: 붙여주고 주소 적고 리턴
	@GetMapping("link8")
	public String method8() {
		return "redirect:/sub25/link7";
	}
	
	// 리다이렉트는 어떻게 attr를 담아서 보내야 할까???
	@GetMapping("link9")
	public String method9(Model model) {
		
		model.addAttribute("attr1", "value1"); // 아님
		
		return "redirect:link10";
	}
	
	@GetMapping("link10")
	public void method10() {
		
	}
	
	// 아래와 같이 리다이렉트 활용 
	// addFlashAttribute
	@GetMapping("link11")
	public String method11(RedirectAttributes rttr) {
		rttr.addFlashAttribute("attr1", "redirect attribute!!");
		// 세션을 이용해서 잠깐 이용하고 지운다
		return "redirect:link10";
	}
	
	@GetMapping("link12")
	public String method12(RedirectAttributes rttr) {
		
		List<String> list = new ArrayList<>();
		list.add("권권");
		list.add("ㅎㅎ");
		
		rttr.addFlashAttribute("list", list); 
		return "redirect:link13";
	}
	
	@GetMapping("link13")
	public void method13() {
		
	}
	
	@GetMapping("link14")
	public String method14(RedirectAttributes rttr) {
//		rttr.addFlashAttribute(rttr) => 목적지의 Model attribute로 담아서 보내줌
		
		// 쿼리스트링으로 붙혀서 넘겨줌
		rttr.addAttribute("address", "seoul");
		
		return "redirect:link15";		
	}

	@GetMapping("link15")
	public String method15(RedirectAttributes rttr) {
		// 쿼리스트링에 붙혀서 보내야함
		
		Scanner sc = new Scanner(System.in);
		String aa = sc.nextLine();
		String bb = sc.nextLine();
		rttr.addAttribute("email", aa);
		rttr.addAttribute("location", bb);
		
		
		return "redirect:link16";
		
	}
	

	
	
	
	@GetMapping("link16")
	public void method16(@RequestParam("email") String email,
			@RequestParam("location") String location) {
		System.out.println(email + " " + "==> 이메일");
		System.out.println(location + " " +  " ==> 장소");
	}
			
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
