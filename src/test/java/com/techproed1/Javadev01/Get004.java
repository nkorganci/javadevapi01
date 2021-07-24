package com.techproed1.Javadev01;

import org.junit.Test;
import org.testng.asserts.SoftAssert;
import static org.hamcrest.Matchers.hasItem;


import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pojos.Data;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matcher;
import org.hamcrest.collection.HasItemInArray;

public class Get004 {

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
	public void get04() {
		
		Response response = given().accept(ContentType.JSON).when().get("http://dummy.restapiexample.com/api/v1/employees");
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		response.prettyPrint();
		
		/*
		 * JsonPath json =response.jsonPath();
		 * assertEquals(24,json.getList("data").size());
		 * assertTrue(json.getList("data.employee_name").contains("Ashton Cox"));
		 */
		
		response.then().assertThat().body("data.employee_name", hasItem("Ashton Cox")).bo;
		
	}
	
	
	
	
}
