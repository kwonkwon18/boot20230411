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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;

@Controller
@RequestMapping("sub13")
public class Controller13 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1(Model model) throws Exception {

		// 전체 주소 추가
		// 전체 고객 출력
		// jsp 에서 테이블 형식으로 보여주기

		String sql = """
				SELECT *
				FROM Customers
				""";
		// Bean 추가
		List<Customer> obj = new ArrayList<>();
		// 1.
		// 2.
		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs;) {
			while (rs.next()) {
				int id = rs.getInt("customerId");
				String name = rs.getString("customerName");
				String address = rs.getString("Address");

				System.out.println(id + ":" + name); // 콘솔 출력

				Customer customer = new Customer();
				customer.setId(id);
				customer.setName(name);
				customer.setAddress(address);
				obj.add(customer);
			}
		}
		// 3. add attribute
		model.addAttribute("customerList", obj);
		// 4.
	}

	@RequestMapping("link2")
	public void method2(Model model) throws Exception {

		String sql = """
				SELECT EmployeeId,
				LastName,
				FirstName
				FROM Employees
				""";

		List<Employee> list = new ArrayList<>();

		Connection con = DriverManager.getConnection(url, name, password);
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			Employee em = new Employee();
			em.setFirstName(rs.getString("FirstName"));
			em.setId(rs.getInt("EmployeeId"));
			em.setLastName(rs.getString("LastName"));
			list.add(em);
		}

		model.addAttribute("employee", list);

	}

	// 경로 : /sub13/link3?id=5
	@RequestMapping("link3")
	public String method3(@RequestParam int id, Model model) throws Exception {
		List<Customer> list = new ArrayList<>();
		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = """;

		// 이렇게 하면 인젝션 당할 수 있음
		sql += id;

//		System.out.println(sql);

		Connection con = DriverManager.getConnection(url, name, password);
		Statement stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(sql);

		try (con; stmt; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("customerid"));
				customer.setAddress(rs.getString("address"));
				customer.setName(rs.getString("customerName"));

				list.add(customer);
			}

		}

		model.addAttribute("customerList", list);

		return "/sub13/link1";
	}

	// customerid 를 param으로 받아서 정해진 경로로 보내기
	@RequestMapping("link4")
	public String method4(@RequestParam String id, Model model) throws Exception {

		String sql = """
				SELECT CustomerId, CustomerName, Address
				FROM Customers
				WHERE CustomerId = ? """;

		List<Customer> list = new ArrayList<>();

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);

		ResultSet rs = st.executeQuery();

		try (con; st; rs;) {
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setAddress(rs.getString("Address"));
				customer.setId(rs.getInt("CustomerId"));
				customer.setName(rs.getString("CustomerName"));
				list.add(customer);
			}
		}

		model.addAttribute(list);

		return "/sub13/link1";
	}

//	// 경로 : /sub13/link4?id=5
//	@RequestMapping("link4")
//	public String method4(@RequestParam String id, Model model) throws Exception {
//		List<Customer> list = new ArrayList<>();
//		String sql = """
//				SELECT CustomerId, CustomerName, Address
//				FROM Customers
//				WHERE CustomerId = ? """;
//
//		Connection con = DriverManager.getConnection(url, name, password);
//		PreparedStatement stmt = con.prepareStatement(sql);
//		stmt.setString(1, id);
//
//		ResultSet rs = stmt.executeQuery();
//
//		try (con; stmt; rs;) {
//			while (rs.next()) {
//				Customer customer = new Customer();
//				customer.setId(rs.getInt("customerid"));
//				customer.setAddress(rs.getString("address"));
//				customer.setName(rs.getString("customerName"));
//
//				list.add(customer);
//			}
//
//		}
//
//		model.addAttribute("customerList", list);
//
//		return "/sub13/link1";
//	}

	// 사용자한테 직원 id 입력 받아서
	// 쿼리 완성하고 실행후에
	// /sub13/link2로 포워드해서 직원 1명 정보 출력

	@RequestMapping("link5")
	public String method5(@RequestParam String id, Model model) throws Exception {

		// sql 명령문 입력 ==> id 는 set 해야하므로 ? 입력
		String sql = """
					SELECT EmployeeId,
				       lastName,
				       firstName
				FROM Employees
				WHERE EmployeeId = ?
				""";

		// 리스트 생성
		List<Employee> employee = new ArrayList<>();

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement st = con.prepareStatement(sql);
		st.setString(1, id);

		ResultSet rs = st.executeQuery();

		try (con; rs; st;) {
			while (rs.next()) {
				Employee em = new Employee();
				em.setFirstName(rs.getString("firstName"));
				em.setLastName(rs.getString("lastName"));
				em.setId(rs.getInt("EmployeeId"));

				employee.add(em);
			}
		}

		model.addAttribute("employee", employee);

		return "/sub13/link2";
	}

//	// /sub13/link5?id=3
//	@RequestMapping("link5")
//	public String method5(String id, Model model) throws Exception {
//		// 사용자에게 직원 id 입력 받아서
//		// 쿼리 완성하고 실행 후에
//		// /sub13/link2 로 포워드해서 직원 1명 정보 출력
//		var list = new ArrayList<Employee>();
//		String sql = """
//				SELECT EmployeeId,
//				       lastName,
//				       firstName
//				FROM Employees
//				WHERE EmployeeId = ?
//				""";
//
//		Connection con = DriverManager.getConnection(url, name, password);
//		PreparedStatement pstmt = con.prepareStatement(sql);
//		pstmt.setString(1, id);
//		ResultSet rs = pstmt.executeQuery();
//
//		try (con; pstmt; rs;) {
//			while (rs.next()) {
//				Employee employee = new Employee();
//				employee.setId(rs.getInt("employeeId"));
//				employee.setFirstName(rs.getString("firstName"));
//				employee.setLastName(rs.getString("lastName"));
//
//				list.add(employee);
//			}
//		}
//
//		model.addAttribute("employeeList", list);
//
//		return "/sub13/link2";
//	}
}
