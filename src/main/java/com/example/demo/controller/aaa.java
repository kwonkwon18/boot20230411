package com.example.demo.controller;

import java.util.regex.Pattern;

public class aaa {

	public boolean isKorean(String str) {
		return Pattern.matches("[가-힣]*$", str);
	}
}