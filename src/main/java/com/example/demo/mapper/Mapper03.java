package com.example.demo.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import com.example.demo.domain.Dto07;
import com.example.demo.domain.Dto09;
import com.example.demo.domain.Dto10;
import com.example.demo.domain.Dto11;
import com.example.demo.domain.Dto12;
import com.example.demo.domain.Employee;

@Mapper
public interface Mapper03 {

	@Insert("""
			insert into MyTable34 (Col1, Col2)
			values (#{val1}, #{val2})
				""")
	int sql1(Integer val1, String val2);

	@Insert("""
			insert into MyTable35 (Col1, Col2)
			values (#{v1}, #{v2})
			""")
	int sql2(Double v1, String v2);

	// 파라미터 1개일 때
	// 프로퍼티명만 작성
	@Insert("""
			insert into MyTable36 (Col1, Col2, Col3)
			values (#{prop1}, #{prop2}, #{prop3})
			""")
	int sql3(Dto09 dto);

	@Insert("""
			insert into MyTable37 (Age, Name, Score)
			values (#{age}, #{name}, #{score})
			""")
	int sql4(Dto10 dto);

	@Insert("""
			insert into MyTable37 (age, name, score)
			values (#{dto09.prop1}, #{dto10.name}, #{dto09.prop3})
					""")
	int sql5(Dto09 dto09, Dto10 dto10);

	// dto1.prop1 -> col1
	// dto2.age -> col2
	// dto1.prop2 -> col3
	// dto2.name -> col4
	// dto1.prop3 -> col5
	// dto2.score -> col6
	@Insert("""
			insert into MyTable38 (Col1, Col2, Col3, Col4, Col5, Col6)
			values (#{dto1.prop1}, #{dto2.age},
			#{dto1.prop2}, #{dto2.name}, #{dto1.prop3}, #{dto2.score})
				""")
	int sql6(Dto09 dto1, Dto10 dto2);
	
	
	@Insert("""
			insert into MyTable39
			(Col2, Col3) values (#{prop2}, #{prop3})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "prop1")
	int sql7(Dto11 dto);
	
	
	@Insert("""
			insert into MyTable40
			(age, name, score)
			values (#{age}, #{name}, #{score})
			""")
	@Options(useGeneratedKeys = true, keyProperty = "id")
	int sql8(Dto12 dto);
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
