package com.example.demo.controller;

import java.net.http.HttpConnectTimeoutException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("sub18")
public class Controller18 {

	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.username}")
	private String name;
	@Value("${spring.datasource.password}")
	private String password;

	// 트랜잭션 없이 모두 실행
	@RequestMapping("link1")
	public void method1() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		try (
				Connection con = DriverManager.getConnection(url, name, password);
				Statement st1 = con.createStatement();
				Statement st2 = con.createStatement();) {
			st1.executeUpdate(sql1);
			st2.executeUpdate(sql2);

			System.out.println("이체 완료 ");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// 트랜잭션 설정 없이 중간에 exception 발생
	// A에서 출금만 진행되고 B는 진행되지 않음
	// 둘다 일어나거나, 둘다 일어나지 말아야함.
	@RequestMapping("link2")
	public void method2() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		try (
				Connection con = DriverManager.getConnection(url, name, password);
				Statement st1 = con.createStatement();
				Statement st2 = con.createStatement();) {
			st1.executeUpdate(sql1);

			// exception 발생
			int a = 3 / 0;

			st2.executeUpdate(sql2);

			System.out.println("이체 완료 ");

		} catch (Exception e) {
			System.out.println("이체 실패 ");
			e.printStackTrace();
		}

	}

	// 트랜잭션 설정 후 모두 성공
	@RequestMapping("link3")
	public void method3() {
		String sql1 = "update Bank set money = money - 5000 where customerName = 'A'";
		String sql2 = "update Bank set money = money + 5000 where customerName = 'B'";

		try (
				Connection con = DriverManager.getConnection(url, name, password);
				Statement st1 = con.createStatement();
				Statement st2 = con.createStatement();) {

			con.setAutoCommit(false);

			st1.executeUpdate(sql1);
			st2.executeUpdate(sql2);

			con.commit();

			System.out.println("이체 완료 ");

		} catch (Exception e) {
			System.out.println("이체 실패 ");
			e.printStackTrace();
		}

	}
	
	// 트랜잭션 설정 후 모두 실패 (중간에 exception 발생시)
	@RequestMapping("link4") 
	public void method4() throws Exception {
		String sql1 = """
				UPDATE Bank
				SET money = money - 5000
				WHERE customerName = 'A'
				""";
		String sql2 = """
				UPDATE Bank
				SET money = money + 5000
				WHERE customerName = 'B'
				""";

		Connection con = DriverManager.getConnection(url, name, password);
		try ( 	con;
				Statement stmt1 = con.createStatement();
				Statement stmt2 = con.createStatement();) {
			con.setAutoCommit(false);
			
			stmt1.executeUpdate(sql1);
			
			// exception 발생
			int a = 5 / 0;
			
			stmt2.executeUpdate(sql2);
			
			con.commit();

			System.out.println("이체 완료");
		} catch (Exception e) {
			System.out.println("이체 실패");
			con.rollback();
			e.printStackTrace();
		}
	}
}
