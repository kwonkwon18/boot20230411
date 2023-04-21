package com.example.demo.controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.domain.Dto05;
import com.example.demo.domain.Dto06;

@Controller
@RequestMapping("sub19")
public class Controller19 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String username;
	@Value("${spring.datasource.password}")
	private String password;

	@RequestMapping("link1")
	public void method1() throws Exception {
		String sql = """
				INSERT INTO MyTable30 (Col1, Col2)
				values (?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setInt(1, 99);
			pst.setString(2, "hello");
			int count = pst.executeUpdate();
			System.out.println(count + " 개 행 실행됨 ");

		}

	}

	@RequestMapping("link2")
	public void method2() throws Exception {
		String sql = """
				INSERT INTO MyTable30 (Col1, Col2)
				values (?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

//			pst.setInt(1, 99);
//			pst.setString(2, "hello");
			// 형식에 비교적 엄격하지 않아 변환될 수 있는 것은 변환이 된다.
			// 숫자로 된 것을 Stringd으로 되는 등등...
			pst.setString(1, "888");
			pst.setInt(2, 12345);
			int count = pst.executeUpdate();
			System.out.println(count + " 개 행 실행됨 ");

		}

	}

	@RequestMapping("link3")
	public void method3() throws Exception {
		String sql = """
				INSERT INTO MyTable31 (Col1, Col2)
				values (?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, "2020-02-02");
			pst.setString(2, "2020-02-01 20:12:20");

			int count = pst.executeUpdate();
			System.out.println(count + " 개 행 실행됨 ");

		}

	}

	@RequestMapping("link4")
	public void method4() throws Exception {
		String sql = """
				INSERT INTO MyTable31 (Col1, Col2)
				values (?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setDate(1, Date.valueOf("2023-03-01"));
			pst.setTimestamp(2, Timestamp.valueOf("1111-11-11 12:12:12"));

			int count = pst.executeUpdate();
			System.out.println(count + " 개 행 실행됨 ");

		}

	}

	// MyTable32 의 행 추가
	@RequestMapping("link5")
	public void method5() throws Exception {

		String sql = """
				insert into MyTable32
				(age, name, price, birth, inserted)
				values (?,?,?,?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {
			pst.setInt(1, 29);
			pst.setString(2, "권권");
			pst.setDouble(3, 1000.10);
			pst.setString(4, "1995-01-18");
			pst.setString(5, "2001-06-12 01:01:01");

			int count = pst.executeUpdate();

			System.out.println(count + "개 행 업데이트 ");

		}

	}

	@RequestMapping("link6")
	public void method6() {
		// forward
	}

	@RequestMapping("link7")
	public void method7(
			@RequestParam("name") String name,
			String age,
			String price,
			String birth,
			String inserted) throws Exception {

		String sql = """
				insert into MyTable32
				(name, age, price, birth, inserted)
				values(?,?,?,?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, name);
			pst.setString(2, age);
			pst.setString(3, price);
			pst.setString(4, birth);
			pst.setString(5, inserted);

			int count = pst.executeUpdate();

			System.out.println(count + "개 입력됨");

		}

	}

	@RequestMapping("link8")
	public void method8(
			@RequestParam("name") String name,
			Integer age,
			Double price,
			LocalDate birth,
			LocalDateTime inserted) throws Exception {

		String sql = """
				insert into MyTable32
				(name, age, price, birth, inserted)
				values(?,?,?,?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, name);
			pst.setInt(2, age);
			pst.setDouble(3, price);
			pst.setDate(4, Date.valueOf(birth));
			pst.setTimestamp(5, Timestamp.valueOf(inserted));

			int count = pst.executeUpdate();

			System.out.println(count + "개 입력됨");

		}

	}

	@RequestMapping("link9")
	public void method9() {
		// 포워딩 해주는 역할
	}

	@RequestMapping("link10")
	public String method10(
			String title,
			LocalDate published,
			Integer price,
			LocalDateTime updated,
			Double weight,
			Model model) throws Exception {

		String sql = """
				insert into MyTable33
				(title, published, price, updated, weight)
				values (?,?,?,?,?)
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				PreparedStatement pst = con.prepareStatement(sql);) {

			pst.setString(1, title);
			pst.setDate(2, Date.valueOf(published));
			pst.setInt(3, price);
			pst.setTimestamp(4, Timestamp.valueOf(updated));
			pst.setDouble(5, weight);

			int count = pst.executeUpdate();

			System.out.println(count);

			return "/sub19/link9";
		}
		
		

	}

	@RequestMapping("link11")
	public void method11() throws Exception {
		String sql = """
				select title, published, price, updated, weight
				from MyTable33
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			if (rs.next()) {
				String title = rs.getString("title");
				String published = rs.getString("published");
				String price = rs.getString("price");
				String updated = rs.getString("updated");
				String weight = rs.getString("weight");

				System.out.println("제목 : " + title);
				System.out.println("출판 : " + published);
				System.out.println("가격 : " + price);
				System.out.println("수정일시 : " + updated);
				System.out.println("무게 : " + weight);
			}

		}
	}

	@RequestMapping("link12")
	public void method12() throws Exception {
		String sql = """
				select title, published, price, updated, weight
				from MyTable33
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			if (rs.next()) {
				String title = rs.getString("title");
				Date published = rs.getDate("published");
				int price = rs.getInt("price");
				Timestamp updated = rs.getTimestamp("updated");
				double weight = rs.getDouble("weight");

				System.out.println("제목 : " + title);
				System.out.println("출판 : " + published);
				System.out.println("가격 : " + price);
				System.out.println("수정일시 : " + updated);
				System.out.println("무게 : " + weight);
			}

		}
	}

	@RequestMapping("link14")
	public void method14(Model model) throws Exception {

		List<Dto05> list = new ArrayList<>();

		String sql = """
				select age, name, price, birth, inserted
				from MyTable32
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				Dto05 o = new Dto05();
				o.setAge(rs.getInt("age"));
				o.setName(rs.getString("name"));
				o.setPrice(rs.getInt("price"));
				o.setBirth(rs.getString("birth"));
				o.setInserted(rs.getString("inserted"));

				list.add(o);
			}

			model.addAttribute("list", list);

		}

	}

	// /sub19/link15
	// 테이블 33에 있는 데이터를 jsp 에서 보여주기
	// 메서드 javaBean,jsp
	// link9 에서 데이터 더 넣기 --> 추가 버튼을 만들어주고 거기로 쏴주면 되는거 아님?

	@RequestMapping("link15")
	public void method15(Model model) throws Exception {

		List<Dto06> list = new ArrayList<>();

		String sql = """
				SELECT *
				from MyTable33 order by price desc
				""";

		try (
				Connection con = DriverManager.getConnection(url, username, password);
				Statement st = con.createStatement();
				ResultSet rs = st.executeQuery(sql);) {

			while (rs.next()) {
				Dto06 o = new Dto06();
				o.setPrice(rs.getInt("price"));
				o.setPublished(rs.getString("published"));
				o.setTitle(rs.getString("title"));
				o.setUpdated(rs.getString("updated"));
				o.setWeight(rs.getDouble("weight"));
				
				list.add(o);
			}
			
			model.addAttribute("list", list);
		}
	}

}
