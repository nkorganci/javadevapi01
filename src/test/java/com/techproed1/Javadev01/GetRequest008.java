package com.techproed1.Javadev01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import testbaseclasses.TestBaseDummyRestapi;
import static io.restassured.RestAssured.*;

public class GetRequest008 extends TestBaseDummyRestapi{
	
	/*
	 When
	 	I send GET Request to URL http://dummy.restapiexample.com/api/v1/employees
	 Then
	 	Status code is 200
	 	1-Print all ids greater than 10 on the console
	 		Assert that there are 14 ids greater than 10
	 	2-Print all ages less than 30 on the console
	 		Assert that maximum age less than 30 is 23
	 	3-Print all employee names whose salaries are greater than 350 000
	 		Assert that "Charde Marshall" is one of the empleyees whose salary is greater than 350 000
	 */
	
	@Test
	public void get() {
		spec.pathParams("api","api",
						"version", "v1",
						"employees","employees");
		
		Response response = given().spec(spec).when().get("/{api}/{version}/{employees}");
		
		response.prettyPrint();
		
		JsonPath json = response.jsonPath();
		
		//1 Print all ids greater than 10 on the console( solution by GROOVY method)
		
		List<String> idList = json.getList("data.findAll{Integer.parseInt(it.id)>10}.id");//valueOf is also working
		System.out.println(idList);
		
		//Assert that there are 14 ids greater than 10
		
		assertEquals(14,idList.size());
		
		//2-Print all ages less than 30 on the console
		List<String> ageList = json.getList("data.findAll{Integer.parseInt(it.employee_age)<30}.employee_age");
		System.out.println(ageList);
		
		Collections.sort(ageList);
					
		//Assert that maximum age less than 30 is 23
		assertEquals(23,(int)age)
		
		

		
	}

}