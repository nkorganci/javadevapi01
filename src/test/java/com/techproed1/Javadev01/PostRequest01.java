package com.techproed1.Javadev01;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import pojos.Bookings;
import pojos.Data;
import pojos.Employees;
import testbaseclasses.TestBaseDummyRestapi;

public class PostRequest01 extends TestBaseDummyRestapi {

	/*
 	POST Request is used to create new data in database.
 	
 	For POST Request we need;
 	1)POST Method
 	2)URL
 	3)Request body
*/

/*
 	When
 	  	I send a POST Request to the Url http://dummy.restapiexample.com/api/v1/create
 	  	by using the following Request Body {
											    "name":"SULEYMAN ALP",
											    "salary":"1000",
											    "age":"33",
											    "profile_image": ""
											}
 	 Then 
 	  	Status code is 200
 	  	And response body should be like {
										    "status": "success",
										    "data": {
										        "name": "SULEYMAN ALP",
										        "salary": "1000",
										        "age": "33",
										        "profile_image": null
										    },
										    "message": "Successfully! Record has been added."
										 }
*/
	
	
	@Test
	public void post01() {
		
		//1 Set the URL
		spec.pathParams("api","api",
						 "version", "v1",
						 "create","create");
		
		//2 Set the posted data
		//1.Way: Use constructor without parameter

//		Data postedData = new Data();
//		postedData.setEmployeeName("Suleyman Alp");
//		postedData.setEmployeeSalary(1000);
//		postedData.setEmployeeAge(33);
//		postedData.setProfileImage("");
		
		//2.Way: use constructor with parameter and type null for id
		Data postedData = new Data(0, "Suleyman Alp", 1000, 33, "");// Did not produce same result
		
		if(postedData.getProfileImage().equals("")){
			postedData.setProfileImage(null);
		}
		
		//3.Way : //4.Way: You can use HashMap to create posted data
		
//		HashMap<String, Object> postedData = new HashMap<>();
//		postedData.put("employee_name", "Suleyman Alp");
		
		System.out.println(postedData);
		
		//3 Send POST request
		Response response= given()
							
							.spec(spec)
							.auth()
							.basic("admin","password123")
							.body(postedData)
						   .when()
								.post("/{api}/{version}/{create}");
				response.prettyPrint();
		
		
		
				//Assertion: GSON + POJO
				Employees actualData = response.as(Employees.class);
				System.out.println(actualData);
				
				assertEquals(postedData.getEmployeeName(), actualData.getData().getEmployeeName());
				assertEquals(postedData.getEmployeeSalary(), actualData.getData().getEmployeeSalary());
				assertEquals(postedData.getEmployeeAge(), actualData.getData().getEmployeeAge());
				assertEquals(postedData.getProfileImage(), actualData.getData().getProfileImage());

		
		
		
		
		
		
		
	}
	
	
	
}
