package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub11")
public class Controller11 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) {
		// 1. request Param

		// 2. business logic
		// 아이디가 1 고객 조회
		// SELECT CustomerName FROM Customers WHERE CustomerID = 1;

		String sql = "SELECT CustomerName FROM Customers WHERE CustomerID = 1";
		try (
				// db 연결
				Connection connection = DriverManager.getConnection(url, name, password);
				// Statement 객체 생성
				// connection으로 연결한 객체에게 Query작업을 실행하기 위한 객체
				// connection.createStatement를 통해 Statement객체 생성
				Statement statement = connection.createStatement();
				// 쿼리실행
				// 쿼리실행 결과 얻고
				// executeQuery 는 조회문을 실행함 => 실제 업무는 얘가 한다.
				// ResultSet => 조회된 목록들이 저장된 객체라고 보자.
				ResultSet resultSet = statement.executeQuery(sql);) {
			// 쿼리실행 결과 가공
			String name = "";
			if (resultSet.next()) {
				name = resultSet.getString("CustomerName");
			}

			// 3. add attribute
			model.addAttribute("customerName", name);
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 4. forward

	}

	@RequestMapping("link2")
	public void method2() {
		String employeeName = "";

		// 2. 비즈니스 로직
		// 아이디 3인 직원의 lastName 조회

		String sql = "SELECT LastName FROM Employees WHERE EmployeeID = 3";
		try {
			// 1. 연결하기
			Connection con = DriverManager.getConnection(url, name, password);
			// 2. statement 생성하기
			Statement st = con.createStatement();
			// 3. 쿼리 실행 후 resultSet 얻기
			ResultSet rs = st.executeQuery(sql);
			// 4. resultSet에 결과 있는지 확인하고
			if (rs.next()) {
				// 5. 결과 꺼내서 담기
				employeeName = rs.getString("lastName");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println(employeeName);
	}

	// 아이디가 5인 상품 이름 조회
	@RequestMapping("link3")
	public void method3(Model model) {

		String productName = "";

		String sql = "SELECT ProductName FROM Products where ProductID = 5";
		try {
			// 1. 연결시키기
			Connection con = DriverManager.getConnection(url, name, password);
			// 2. statement 객체 생성
			Statement st = con.createStatement();
			// statement 객체 실행 => 담는 곳 ResultSet
			ResultSet rs = st.executeQuery(sql);
			// 담긴 쿼리 실행 결과를 출력
			if (rs.next()) {
				// 이름을 가져옴
				productName = rs.getString("ProductName");
			}

			model.addAttribute("productName", productName);

			System.out.println(productName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 업무 : 고객 이름들 조회
	@RequestMapping("link4")
	public void method4(Model model) {
		String sql = """
				SELECT CustomerName
				FROM Customers
				""";
		// list에 고객 이름들을 담고
		List<String> list = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				list.add(rs.getString("CustomerName"));
			}
			model.addAttribute("customerNames", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// forward
	}

//	// 직원이름 (firstName) 조회해서 출력
//	@RequestMapping("link5")
//	public void method5(Model model) {
//
//		String sql = "SELECT FirstName From Employees";
//
//		// 결과를 담을 List 만들어주기
//		List<String> list = new ArrayList<>();
//
//		try {
//
//			// 1. 연결하기
//			Connection con = DriverManager.getConnection(url, name, password);
//
//			// 2. statement 객체 생성
//			Statement st = con.createStatement();
//
//			// 3. statement 에서 sql 구문 실행 및 결과 값 ResultSet에 담기
//			ResultSet rs = st.executeQuery(sql);
//
//			// ResultSet 에 담은 값 들을 출력
//			while (rs.next()) {
//				list.add(rs.getString("FirstName"));
//			}
//
//			// 값을 model에 담기
//			model.addAttribute("EmployeesName", list);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}

	// 직원이름 (firstName) 조회해서 출력
	@RequestMapping("link5")
	public void method5(Model model) {

		String sql = "SELECT FirstName, LastName From Employees";

		// 결과를 담을 List<MAP> 만들어주기
		List<Map<String, String>> list = new ArrayList<>();

		try {

			// 1. 연결하기
			Connection con = DriverManager.getConnection(url, name, password);

			// 2. statement 객체 생성
			Statement st = con.createStatement();

			// 3. statement 에서 sql 구문 실행 및 결과 값 ResultSet에 담기
			ResultSet rs = st.executeQuery(sql);

			// ResultSet 에 담은 값 들을 출력
			while (rs.next()) {
				Map<String, String> map = new HashMap<>();
				map.put("FirstName", rs.getString("FirstName"));
				map.put("LastName", rs.getString("LastName"));
				list.add(map);
			}

			// 값을 model에 담기
			model.addAttribute("EmployeesName", list);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
