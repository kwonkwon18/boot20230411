package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.example.demo.domain.Customer;
import com.example.demo.domain.Employee;

@Mapper
public interface Mapper05 {

	@Update("""
			UPDATE MyTable39
			SET 
				Col2 = '수정된 값',
				Col3 = 99999
			""")
	int sql1();
	
	@Update("""
			UPDATE MyTable39
			SET 
				Col2 = #{val1},
				Col3 = #{val2}
			WHERE 
				Col1 = #{key}
			""")
	int sql2(Integer key, String val1, Integer val2);
	
	
	@Update("""
			update Customers
			set
				CustomerName = #{name},
				Country = #{country}
			where
				CustomerId = #{key}
			""")
	int sql3(Integer key, String name, String country);
	
	@Update("""
			UPDATE Customers
			SET
				CustomerName = #{name},
				ContactName = #{contactName},
				Address = #{address},
				City = #{city},
				PostalCode = #{postalCode},
				Country = #{country}
			WHERE 
				CustomerId = #{id}
			""")
	int sql4(Customer customer);

	@Select("""
			SELECT 
				CustomerId id,
				CustomerName name,
				ContactName,
				Address,
				City,
				Country,
				PostalCode
			FROM Customers
			WHERE CustomerId = #{id}
			""")
	Customer sql5(Integer id);
	
	
	@Select("""
			select 
				EmployeeId id,
				lastname,
				firstname,
				birthdate,
				photo,
				notes
			From Employees
			Where employeeid = #{eid}
			""")
	Employee sql6(Integer eid);
	
	@Update("""
			UPDATE Employees
				set
				lastname = #{lastName},
				firstname = #{firstName},
				birthdate = #{birthdate},
				photo = #{photo},
				notes = #{notes}
			WHERE EmployeeID = #{id}
			""")
	int sql7(Employee em);
	
}




