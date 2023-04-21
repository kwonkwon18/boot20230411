package com.example.demo.controller;

import java.awt.Taskbar.State;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.tags.shaded.org.apache.regexp.recompile;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub12")
public class Controller12 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() {

		String sql = """
				SELECT LastName FROM Employees
				""";

		try {

			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			try (con; st; rs;) {

				System.out.println(rs.next()); // true
				// 해당 행의 특정 열을 가지고 오는 Resultset 메서드 ==> get으로 시작하는 메서드들
				String name1 = rs.getString("LastName");
				System.out.println(name1);
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // true
				System.out.println(rs.next()); // false
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("link2")
	public void method2() {

		String sql = """
				SELECT LastName FROM Employees
				""";

		try {

			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			try (con; st; rs;) {
				while (rs.next()) {
					System.out.println(rs.getString("LastName"));
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link3")
	public void method3(Model model) {

		String sql = "select * from Shippers";
		List<String> list = new ArrayList<>();

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			try (con; st; rs;) {

				while (rs.next()) {
					System.out.println(rs.getString("Phone"));
					list.add(rs.getString("Phone"));
				}
				model.addAttribute("name", list);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link4")
	public void method4() {
		String sql = "select * from Customers";

		try {
			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			try (con; st; rs;) {
				while (rs.next()) {
					System.out.println(rs.getString("customerName"));
					System.out.println(rs.getString("country"));
					System.out.println(rs.getString("ContactName")); // ContactName
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link6")
	public void method6() throws Exception {
		String sql = "select * from Products where productid <= 3";

		Connection con = DriverManager.getConnection(url, name, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			System.out.println(rs.getInt("ProductId")); // Integer 형식이지만 가능함
			System.out.println(rs.getString("ProductName"));
			System.out.println(rs.getDouble("price")); // Double 형식이지만 가능함
		}

	}

	// customerid ==> int
	// customername ==> String
	@RequestMapping("link7")
	public void method7(Model model) {

		String sql = """
				select * from Customers
				where CustomerID < 4
								""";
		try {

			List<String> list1 = new ArrayList<>();
			List<Integer> list2 = new ArrayList<>();

			Connection con = DriverManager.getConnection(url, name, password);
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);

			try (con; rs; st;) {
				while (rs.next()) {
					list1.add(rs.getString("customername"));
					list2.add(rs.getInt(1));
				}
				model.addAttribute("name", list1);
				model.addAttribute("id", list2);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("link9")
	public void method9() throws Exception {

		// 고객 테이블 조회 쿼리 완성
		// 나머지 코드들도 완성

		String sql = "select * from Customers where customerId < 11";

		Connection con = DriverManager.getConnection(url, name, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {

			int customerId = rs.getInt(1);
			String customerName = rs.getString(2);
			String country = rs.getString(3);

			System.out.println(customerId + "  " + customerName + "  " + country);

		}
	}

}
