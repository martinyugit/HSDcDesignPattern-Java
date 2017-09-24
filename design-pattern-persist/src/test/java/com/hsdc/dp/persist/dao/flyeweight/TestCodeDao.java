package com.hsdc.dp.persist.dao.flyeweight;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hsdc.dp.intf.dao.flyweight.CodeDao;
import com.hsdc.dp.intf.dto.flyweight.CodeDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:META-INF/spring/app-persist-context.xml" })
public class TestCodeDao {
	@Autowired private CodeDao dao;

	@Test
	public void test_retrieve_city_ok() {
		String input = "CITY";
		List<CodeDto> dtos = dao.query(input);
		assertNotNull(dtos);
		for(CodeDto d : dtos)
			System.out.println(d);
	}
	
	@Test
	public void test_retrieve_area_ok() {
		String input = "AREA";
		String input2 = "TPE";
		List<CodeDto> dtos = dao.query(input, input2);
		assertNotNull(dtos);
		for(CodeDto d : dtos)
			System.out.println(d);
	}

}
