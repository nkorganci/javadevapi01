package com.techproed1.Javadev01;

import static io.restassured.RestAssured.given;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import io.restassured.response.Response;

public class GetRequest004 {
	/*
	 
	 When
	 	I send a GET request to REST API URL http://dummy.restapiexample.com/api/v1/employees
	 	And Accept type is "application/JSON"
	 Then
	 	HTTP Status Code should be 200
	 	And Response format should be "application/JSON"
	 	And there should be 24 employees
	 	And "Ashton Cox" should be one of the employees
	 	And 21, 61, and 23 should be among the employee ages
	 	
	 		
	 
	 */
	
	@Test
	
	public void get01() {
		
		String url = "http://dummy.restapiexample.com/api/v1/employees";
		Response response = given().accept("aplication/json").when().get(url);
		response.prettyPrint();
		
		response.
		then().
		assertThat().
		statusCode(200).body(
				"data.id",hasSize(24), 
				"data.employee_name", hasItem("Ashton Coxx"),
				"data.employee_age", hasItems("21","61","23"));
	}
	
	
}
