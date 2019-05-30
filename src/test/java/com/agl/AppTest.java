package com.agl;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.agl.Application;
import com.agl.ResultMap;

public class AppTest {

	@Test
	public void testClassificationByGender() {
		String petType="cat";
		String json = "[\n" + 
				"{\n" + 
				"\"name\": \"Bob\",\n" + 
				"\"gender\": \"Male\",\n" + 
				"\"age\": 23,\n" + 
				"\"pets\": [\n" + 
				"{\n" + 
				"\"name\": \"Garfield\",\n" + 
				"\"type\": \"Cat\"\n" + 
				"},\n" + 
				"{\n" + 
				"\"name\": \"Fido\",\n" + 
				"\"type\": \"Dog\"\n" + 
				"}\n" + 
				"]\n" + 
				"}]";
		ResultMap map = Application.classifyPetNamesByGender(json, petType);
		assertEquals(1, map.size());
	}
}
