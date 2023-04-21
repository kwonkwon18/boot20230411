package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Dto07;
import com.example.demo.domain.Employee;

@Mapper
public interface Mapper02 {

	@Select("""
			select CustomerName from Customers
				""")
	List<String> sql1();
	
	@Select("""
			Select LastName FROM Employees
			
			""")
	List<String> sql2();
	
	@Select("""
			select LastName firstName, FirstName lastName
			FROM Employees
			""")
	List<Employee> sql3();
	
	@Select("""
			select productName, price
			from Products
			""")
	List<Dto07> sql4();
	
	@Select("""
			select productName
			FROM Products
			WHERE CategoryId = #{cid}
			""")
	List<String> sql5(Integer cid);
	
	@Select("""
			select CustomerName
			From Customers
			WHERE Country = #{name}
			""")
	List<String> sql6(String name);
	
	@Select("""
			select productname, price
			from Products
			where Categoryid = #{cid}
			""")
	List<Dto07> sql7(Integer cid);
	

}


