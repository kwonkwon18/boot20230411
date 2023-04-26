package com.example.demo;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.demo.domain.Employee;

@SpringBootApplication
public class Boot20230411Application {

	public static void main(String[] args) {
		// Spring Bean : 스프링이 관리하는 객체들
		SpringApplication.run(Boot20230411Application.class, args);


	}

	// 우리가 객체를 직접 만들 때
	public void legacy() {
		Object o = new Object(); // 직접 만든 객체
		Employee e = new Employee(); // 직접 만든 객체

		e.setId(100); // 프로퍼티 직접 할당
	}

}
