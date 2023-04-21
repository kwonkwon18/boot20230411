package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Supplier;

@RequestMapping("sub15")
@Controller
public class Controller15 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() throws Exception {
		// 새 customer 넣기
		String sql = """
				insert into Customers (Customerid, customerName, City)
				values (92, '박지성', '맨체스터')
				""";

		// insert, update, delete 는
		// statement 의 executeUpdate 사용
		// 리턴 값은 영향을 미친 레코드 수 !
		// 하나 인서트 했으면 1, 인서트 못했으면 0

		Connection con = DriverManager.getConnection(url, name, password);
		Statement st = con.createStatement();
//		ResultSet rs = st.executeQuery(sql); ==> executeQuery 는 조회할 때만 사용할 수 있다. 
		int count = st.executeUpdate(sql);
		try (con; st;) {

		}

		System.out.println(count + " 개 행 추가됨");

	}

	// /sub15/link2로 요청을 보냈을 때,
	// 10번째 직원 추가

	@RequestMapping("link2")
	public void method2() throws Exception {
		// 인서트문
		String sql = """
				insert into Employees (employeeid, lastname, firstname)
				values (10, '윤', '대협')
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		Statement st = con.createStatement();
		int count = st.executeUpdate(sql);

		con.close();
		st.close();

		System.out.println(count + "개 행 추가됨");

	}

	// /sub15/link3?customerName=송태섭&city=부산&country=한국
	@RequestMapping("link3")
	public void method3(
			@RequestParam("customerName") String customerName,
			@RequestParam("city") String city,
			@RequestParam("country") String country) throws Exception {
		String sql = """
				insert into Customers
				(customerName, city, country)
				values
				(?,?,?)
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, customerName);
		st.setString(2, city);
		st.setString(3, country);

		int count = st.executeUpdate();

		con.close();
		st.close();

		System.out.println(count + " 개 행 추가됨");

	}

	// sub15/link4?firstName=차두리&lastName=차미네이터
	// 직원 정보 추가
	@RequestMapping("link4")
	public void method3(@RequestParam String firstName, @RequestParam String lastName) throws Exception {
		// insert
		String sql = """
				insert into Employees (lastname, firstname)
				values (?, ?)
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, firstName);
		st.setString(2, lastName);

		int count = st.executeUpdate();

		con.close();
		st.close();

		System.out.println(count + "개 행이 추가되었습니다. ");

	}

	@RequestMapping("link5")
	public void method5() {
		// form 이 있는 view로 포워드

		// view : /sub15/link5

	}

	@RequestMapping("link6")
	public String method6(
			String firstName,
			String lastName,
			Model model) throws Exception {

		List<Employee> list = new ArrayList<>();

		// 삽입
		String sql1 = """
				insert Employees (firstname, lastname)
				values (?, ?)
				""";

		// 조회
		String sql2 = """
				select * from Employees order by 1 desc
				""";

		// 삽입
		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql1);
		Statement stt = con.createStatement();
		st.setString(1, firstName);
		st.setString(2, lastName);

		int count = st.executeUpdate();

		// 조회
		ResultSet rs = stt.executeQuery(sql2);

		while (rs.next()) {
			Employee em = new Employee();
			em.setLastName(rs.getString("LastName"));
			em.setFirstName(rs.getString("FirstName"));
			list.add(em);
		}

		con.close();
		st.close();
		stt.close();
		rs.close();

		model.addAttribute("employee", list);

		System.out.println(count);
		System.out.println(firstName);
		System.out.println(lastName);

		return "sub13/link2";

	}

	// 경로 : /sub15/link7
	// 폼이 있는 jsp로 포워드
	@RequestMapping("link7")
	public void method7() {
		// form 이 있는 view로 포워드

		// view : /sub15/link5

	}

	// 경로 : /sub15/link8
	// ****** dto 활용
	@RequestMapping("link8")
	public void method8(
			String name,
			String city,
			String country) throws Exception {
		// 3개 메소드 파라미터 활용해서
		// suppliers 테이블에 레코드 추가

		String sql = """
				insert into Suppliers (SupplierName, city, country)
				values (?, ?, ?)
				""";
		// 변수의 name 과 변수명이 겹칠 수 있으므로 this 를 붙여줘야한다.
		Connection con = DriverManager.getConnection(url, this.name, password);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, name);
		pst.setString(2, city);
		pst.setString(3, country);

		int count = pst.executeUpdate();

		con.close();
		pst.close();

		System.out.println(count + "개 추가되었습니다. ");

	}

	@RequestMapping("link9")
	public void method9() {

	}

	@RequestMapping("link10")
	public void method10(
			@ModelAttribute("customer") Customer customer) throws Exception {

		String sql = """
				Insert into Customers
				(CustomerName, ContactName, Address)
				values
				(?, ?, ?)
				""";
		try (

				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, customer.getName());
			pst.setString(2, customer.getContactName());
			pst.setString(3, customer.getAddress());

			int count = pst.executeUpdate();

			System.out.println(count);
		}
	}

	// 경로 : /sub15/link11
	@RequestMapping("link11")
	public void method11() {

	}

	@RequestMapping("link12")
	@ResponseBody
	public String method12(Supplier supplier) throws Exception {

		String sql = """
				insert into Suppliers
				(SupplierName,ContactName,Address,City,PostalCode,Country,Phone)
				values(?,?,?,?,?,?,?)
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		// 자동으로 생성되는 컬럼을 가져올 수 있음
		PreparedStatement pst = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

		pst.setString(1, supplier.getSupplierName());
		pst.setString(2, supplier.getContactName());
		pst.setString(3, supplier.getAddress());
		pst.setString(4, supplier.getCity());
		pst.setString(5, supplier.getPostalCode());
		pst.setString(6, supplier.getCountry());
		pst.setString(7, supplier.getPhone());

		int count = pst.executeUpdate();

		// 자동 생성된 컬럼(키) 값 얻기
		ResultSet generatedKeys = pst.getGeneratedKeys();
		int keyValue = 0;

		if (generatedKeys.next()) {
			keyValue = generatedKeys.getInt(1);
		}

		con.close();
		pst.close();

		System.out.println(count + "개 생성 ");
		System.out.println(keyValue + "번 공급자 번호 입력됨");

		return keyValue + "번 공급자 데이터 입력됨";

	}

}
