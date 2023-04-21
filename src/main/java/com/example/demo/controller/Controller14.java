package com.example.demo.controller;

import java.sql.*;
import java.util.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.bind.annotation.*;

import com.example.demo.domain.*;

@Controller
@RequestMapping("sub14")
public class Controller14 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	// 추가업무 : ContactName에도 키워드 조회 추가
	// 1. 쿼리 수정
	// 2. pstmt에 2번째 물음표에 set 하는 코드 추가
	// 3. Customer 자바빈의 contactName 프로퍼티 추가
	// 4. /sub13/link1 뷰에 contactName 속성 출력하는 테이블 열 추가

	@RequestMapping("link1")
	public String method(@RequestParam String keyword1,
			@RequestParam String keyword2,
			Model model) throws Exception {

		String sql = """
				SELECT CustomerID, CustomerName, Address, ContactName
						FROM Customers
						WHERE CustomerName LIKE ?
						AND ContactName LIKE ?
				""";

		// list 만들기

		List<Customer> customerList = new ArrayList<>();

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, "%" + keyword1 + "%");
		st.setString(2, "%" + keyword2 + "%");

		ResultSet rs = st.executeQuery();

		try (con; st; rs;) {
			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("customerId"));
				c.setAddress(rs.getString("address"));
				c.setName(rs.getString("customerName"));
				c.setContactName(rs.getString("contactName"));

				customerList.add(c);
			}
		}

		model.addAttribute("customerList", customerList);

		return "/sub13/link1";
	}

	// employees 테이블에 쿼리스트링으로 받은 것들을 추가
	@RequestMapping("link2")
	public void method2(String last, String first, int id) throws Exception {

		String sql = """
				insert Employees (EmployeeID, LastName, FirstName)
				values (?, ?, ?)
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);
		st.setString(2, last);
		st.setString(3, first);

		ResultSet rs = st.executeQuery();

		st.close();
		con.close();
		rs.close();

		System.out.println("추가성공");

	}

	// employees 테이블에 쿼리스트링으로 받은 것들을 삭제
	@RequestMapping("link3")
	public void method2(int id) throws Exception {

		String sql = """
				delete from Employees
				where EmployeeID = ?
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(1, id);

		ResultSet rs = st.executeQuery();

		st.close();
		con.close();
		rs.close();

		System.out.println("삭제성공");

	}

	// employees 테이블에 쿼리스트링으로 받은 것을 업데이트
	@RequestMapping("link4")
	public void method2(int id, String last, String first) throws Exception {

		String sql = """
				update Employees
				set LastName = ?, FirstName = ?
				where EmployeeID = ?
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setInt(3, id);
		st.setString(1, last);
		st.setString(2, first);

		ResultSet rs = st.executeQuery();

		st.close();
		con.close();
		rs.close();

		System.out.println("수정성공");

	}

//	// /sub14/link1?keyword=or
//	@RequestMapping("link1")
//	public String method1(String keyword, Model model) throws Exception {
//		String sql = """
//				SELECT CustomerID, CustomerName, Address, ContactName
//				FROM Customers
//				WHERE CustomerName LIKE ?
//				   OR ContactName LIKE ?
//				""";
//		var list = new ArrayList<Customer>();
//		
//		Connection con = DriverManager.getConnection(url, name, password);
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, "%" + keyword + "%");
//		pstmt.setString(2, "%" + keyword + "%");
//		ResultSet rs = pstmt.executeQuery();
//		
//		try (con; pstmt; rs;) {
//			while (rs.next()) {
//				Customer c = new Customer();
//				c.setId(rs.getInt("customerId"));
//				c.setAddress(rs.getString("address"));
//				c.setName(rs.getString("customerName"));
//				c.setContactName(rs.getString("contactName"));
//				
//				list.add(c);
//			}
//		}
//		
//		model.addAttribute("customerList", list);
//		
//		return "/sub13/link1";
//	}
}
