package com.example.demo.mapper;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Dto05;
import com.example.demo.domain.Dto06;
import com.example.demo.domain.Employee;
import com.example.demo.domain.Supplier;

@Mapper
public interface Mapper01 {

	// 추상메서드 만듦
	// CRUD 어노테이션을 붙여줌
	@Select("""
			select CustomerName
			From Customers
			Where CustomerId = 1
					""")
	public String method1();

	
	@Select("""
			SELECT FirstName
			FROM Employees
			WHERE EmployeeId = 1
					""")
	String method2();
	
	
	// 1번 공급자의 공급자명 출력
	@Select(
			"""
			SELECT SupplierName
			From Suppliers
			Where SupplierID = 1
					"""
			)
	String method3();

	
	@Select("""
			SELECT CustomerName
			FROM Customers
			WHERE CustomerID = #{id}
			""")
	String method4(Integer id);
	
	@Select("""
			SELECT lastName
			From Employees
			WHERE employeeID = #{id}
			""")
	String method5(Integer id);
	
	
	
	@Select("""
			select price 
			from MyTable33
			Limit 1
			""")
	Integer method6();
	
	
	@Select("""
			select weight
			from MyTable33
			limit 1
			""")
	Double method7();
	
	@Select("""
			select published
			From MyTable33
			limit 1
			""")
	LocalDate method8();
	
	@Select("""
			select updated
			from MyTable33
			limit 1
			""")
	LocalDateTime method9();
	
	@Select("""
			select title,
					published,
					price,
					updated,
					weight
			from MyTable33
			Limit 1
			""")
	// 컬럼명과 대소문자 구분 없이 매치되는
	// 빈의 프로퍼티명
	Dto06 method10();
	
	@Select("""
			SELECT 
				Name,
				age,
				price,
				birth,
				inserted
			From MyTable32
			limit 1
			""")
	Dto05 method11();
	
	@Select("""
			SELECT 
				Customerid id,
				customername name,
				contactName,
				address,
				city,
				postalCode,
				country
			From Customers
			WHERE Customerid = 7
			""")
		Customer method12();
	
	@Select("""
			SELECT 
				SupplierID id,
				SupplierName name,
				ContactName,
				address,
				city,
				postalcode,
				country,
				phone
			From Suppliers
			WHERE supplierid = #{id}
			""")
	Supplier method13(Integer id);
	
	@Select("""
			SELECT 
				EmployeeID id,
				LastName lastname,
				FirstName firstname,
				BirthDate birthdate,
				photo photo,
				notes note 
			FROM Employees
			WHERE EmployeeID = #{id}
			""")
	Employee method14(Integer id);
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
