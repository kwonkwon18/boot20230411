package com.example.demo.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("sub16")
public class Controller16 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	// /sub16/link1?id=33
	@RequestMapping("link1")
	public void method1(int id) throws Exception {

		String sql = """
				DELETE FROM Suppliers
				WHERE SupplierId = ?
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		PreparedStatement pst = con.prepareStatement(sql);
		pst.setInt(1, id);
		int count = pst.executeUpdate();

		System.out.println(count + "개 데이터 삭제됨 ");

	}

	// 경로 : /sub16/link2?id=30
	// 고객 테이블의 데이터 삭제 메서드 작성
	@RequestMapping("link2")
	public void method2(int id) {

		String sql = """
				DELETE FROM Customers
				WHERE CustomerId = ?
				""";

		Connection con;
		try {
			con = DriverManager.getConnection(url, name, password);
			PreparedStatement pst = con.prepareStatement(sql);
			pst.setInt(1, id);

			int count = pst.executeUpdate();
			
			con.close();
			pst.close();
			
			System.out.println(count + "행이 제거되었습니다. ");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		


	}

}
