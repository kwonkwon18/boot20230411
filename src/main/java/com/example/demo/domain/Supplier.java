package com.example.demo.domain;

import lombok.Data;

@Data
public class Supplier {
	private int id;
	private String name;
	private String contactName;
	private String address;
	private String city;
	private String country;
	private String postalCode;
	private String phone;
}