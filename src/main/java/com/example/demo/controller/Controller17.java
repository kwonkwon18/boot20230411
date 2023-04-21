package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Shipper;
import com.example.demo.domain.Supplier;

@Controller
@RequestMapping("sub17")
public class Controller17 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	// ?id=65&name=서태웅
	@RequestMapping("link1")
	public void method1(int id, String name) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?
				WHERE SupplierId = ?
				""";
		try (
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, name);
			pstmt.setInt(2, id);

			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 수정됨");

		}

	}

	// /sub17/link2?id=62&address=seoul
	// supplierid 가 62번인 공급자 주소(address)를 seoul로 바꾸는 메소드
	@RequestMapping("link2")
	public void method2(int id, String address) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					Address = ?
				WHERE SupplierId = ?
				""";

		try (
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, address);
			pstmt.setInt(2, id);
			int cnt = pstmt.executeUpdate();
			System.out.println(cnt + "개 행 수정됨");

		}

	}

	@RequestMapping("link3")
	public void method3(Supplier supplier) throws Exception {
		String sql = """
				UPDATE Suppliers
				SET
					SupplierName = ?,
					ContactName = ?,
					Address = ?,
					City = ?,
					PostalCode = ?,
					Country = ?,
					Phone = ?
				WHERE
					SupplierId = ?
				""";

		try (
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {
			pstmt.setString(1, supplier.getName());
			pstmt.setString(2, supplier.getContactName());
			pstmt.setString(3, supplier.getAddress());
			pstmt.setString(4, supplier.getCity());
			pstmt.setString(5, supplier.getPostalCode());
			pstmt.setString(6, supplier.getCountry());
			pstmt.setString(7, supplier.getPhone());
			pstmt.setInt(8, supplier.getId());

			int cnt = pstmt.executeUpdate();
			System.out.println(supplier.getId() + "번 공급자 수정됨");

		}

	}

	// /sub17/link4?id=65
	@RequestMapping("link4")
	public void method4(int id, Model model) throws Exception {
		String sql = """
				SELECT
					SupplierId,
					SupplierName,
					ContactName,
					Address,
					City,
					PostalCode,
					Country,
					Phone
				FROM Suppliers
				WHERE SupplierId = ?
				""";
		try (
				Connection con = DriverManager.getConnection(url, name, password);
				PreparedStatement pstmt = con.prepareStatement(sql);) {

			pstmt.setInt(1, id);
			try (ResultSet rs = pstmt.executeQuery();) {
				if (rs.next()) {
					Supplier supplier = new Supplier();
					supplier.setId(rs.getInt("supplierId"));
					supplier.setName(rs.getString("supplierName"));
					supplier.setContactName(rs.getString("contactName"));
					supplier.setAddress(rs.getString("address"));
					supplier.setCity(rs.getString("city"));
					supplier.setPostalCode(rs.getString("postalCode"));
					supplier.setCountry(rs.getString("country"));
					supplier.setPhone(rs.getString("phone"));
					model.addAttribute("supplier", supplier);
				}

			}

		}
	}

	// 고객 조회 (method4) 참고, 고객 번호를 참조할 수 있게
	@RequestMapping("link5")
	public void method5(int id, Model model) throws Exception {

		String sql = """
				SELECT *
				FROM Customers
				WHERE CustomerId = ?
				""";

		Connection con = DriverManager.getConnection(url, this.name, password);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);

		ResultSet rs = pst.executeQuery();

		if (rs.next()) {
			Customer customer = new Customer();
			customer.setAddress(rs.getString("address"));
			customer.setCity(rs.getString("city"));
			customer.setContactName(rs.getString("ContactName"));
			customer.setCountry(rs.getString("country"));
			customer.setName(rs.getString("CustomerName"));
			customer.setId(rs.getInt("CustomerId"));
			customer.setPostalCode(rs.getString("PostalCode"));
			model.addAttribute("customer", customer);
		}

		con.close();
		rs.close();
		pst.close();

	}

	// 고객정보 수정(method3 참고)
	@RequestMapping("link6")
	public void method6(Customer customer) throws Exception {

		String sql = """
				UPDATE Customers
				SET
					address = ?,
					city = ?,
					ContactName = ?,
					country = ?,
					CustomerName = ?,
					PostalCode = ?
					WHERE CustomerID = ?
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, customer.getAddress());
		pst.setString(2, customer.getCity());
		pst.setString(3, customer.getContactName());
		pst.setString(4, customer.getCountry());
		pst.setString(5, customer.getName());
		pst.setString(6, customer.getPostalCode());
		pst.setInt(7, customer.getId());

		int count = pst.executeUpdate();

		con.close();
		pst.close();

		System.out.println(customer.getId() + "번 수정 완료");

	}

	// Shippers 테이블을 조회 하여
	// 그 테이블에서 특정 id 의 값을 참고하여
	// 수정 view 단으로 넘긴 후
	// view단에서 수정 컨트롤러로 넘겨서 진행해보자
	// ==> 아래의 긴 코드들도 Service 부분으로 넘겨서
	// 실제 컨트롤러에는 메서드들의 집합으로 이뤄지게 할 수 있다. 

	@RequestMapping("link7")
	public void method7(int id, Model model) throws Exception {

		String sql = """
				SELECT * FROM Shippers
				WHERE ShipperID = ?
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();

		con.close();
		pst.close();

		if (rs.next()) {
			Shipper s = new Shipper();
			s.setId(rs.getInt("ShipperId"));
			s.setName(rs.getString("ShipperName"));
			s.setPhone(rs.getString("Phone"));
			model.addAttribute("shipper", s);
		}

	}

	@RequestMapping("link8")
	public void method8(Shipper shipper) throws Exception {

		String sql = """
				UPDATE Shippers
				SET
					ShipperName = ?,
					Phone = ?
				where ShipperId = ?
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setString(1, shipper.getName());
		pst.setString(2, shipper.getPhone());
		pst.setInt(3, shipper.getId());
		
		int count = pst.executeUpdate();
		
		con.close();
		pst.close();



		System.out.println(count + "행 수정");

	}

}