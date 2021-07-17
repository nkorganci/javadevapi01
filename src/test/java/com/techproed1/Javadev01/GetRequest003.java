package com.techproed1.Javadev01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;



public class GetRequest003 {
	
	
	/*
	 When: 
	 		I sent a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/23;
	 		And Accept type is "application/JSON"
	 Then: 
	 		HTTP status code should be 200
	 		And: response format should be "application/JSON"
	 		And: "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
	 		And: "completed" is false
	 		And : "userID" is 2
	 */

		@Test
		
		public void get01() {
			
			//1 set URL
			String url = "https://jsonplaceholder.typicode.com/todos/23";
			
			//2 Set the expected data
			//3 Send request
			Response response = given().when().get(url);
			response.prettyPrint();
			
			//4 Assertion-> hard assertion
			//1.Way
			response.
				then().
				assertThat().
				statusCode(200).
				contentType(ContentType.JSON).
				body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit")).
				body("completed", equalTo(false)).
				body("userID", equalTo(2));
			
			//2.Way, no need to have body for each.
			response.
				then().
				assertThat().
				statusCode(200).
				contentType(ContentType.JSON).
				body("title",equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),"completed", equalTo(false),"userID", equalTo(2));
			
			//3.Way
			assertEquals(200, response.getStatusCode());
			
			assertTrue(response.getStatusCode()==200);// Same with assertEqual but not recommenced, not has a report.
			
			assertEquals("application/json; charset=utf-8", response.getContentType());
			assertTrue(response.asString().contains("et itaque necessitatibus maxime molestiae qui quas velit"));
			
				
			
		}
}
