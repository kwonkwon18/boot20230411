package com.example.demo.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ComponentE {

	// 스프링 빈으로 만든 객체를 자동적으로 할당해준다.
	// 자동으로 인젝션 해준다.
	@Autowired
	private ComponentD comp;

	public ComponentD getComp() {
		return comp;
	}

}
