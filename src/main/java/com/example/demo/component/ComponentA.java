package com.example.demo.component;

public class ComponentA {

	private ComponentB comp;

	public ComponentA(ComponentB comp) {
		this.comp = comp;
	}

	public ComponentB getComp() {
		return comp;
	}

	public void setComp(ComponentB comp) {
		this.comp = comp;
	}

}
