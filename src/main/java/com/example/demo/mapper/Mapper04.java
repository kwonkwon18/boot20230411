package com.example.demo.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface Mapper04 {

	@Delete("""
			delete from MyTable40
			""")
	int sql1();
	
	@Delete("""
			delete from MyTable39
			Where Col1 = #{cid}
			""")
	int sql2(Integer id);
	
	
	@Delete("""
			delete from Customers
			where Customerid = #{cid}
			""")
	int sql3(Integer cid);
	
	
	
	
	
	
	
	
	
	
	
	
	

}
