package com.techproed1.Javadev01;

import static org.hamcrest.Matchers.*;
import org.junit.Test;

import io.restassured.response.Response;
import testbaseclasses.TestBaseJsonPlaceHolder;

import static io.restassured.RestAssured.*;

public class GetRequest005 extends TestBaseJsonPlaceHolder {
	
	
	/*
	 
	 When
	 	I send a GET request to REST API URL https://jsonplaceholder.typicode.com/todos/123
	 Then
	 	HTTP Status Code should be 200
	 	And "Server" in Headers should be "cloudflare"
	 	And response content type is "application/JSON"
	 	And "userId" should be 7,
	 	And "title" should be "esse et quis iste est earum aut impedit"
	 	And "completed" should be false
	 
	 */
	
	@Test
	
	public void get01() {
		
		//1 Set the url
		spec.pathParams("todoName1", "todos",
						"id",123);
		
		//2 Set the expected value
		
		//3 Send the request
		Response response = given().accept("application/json").spec(spec).when().get("/{todoName1}/{id}");
		response.prettyPrint();
			
		
		//3 assertions
		
		response.
		then().
		assertThat().
		statusCode(200).
		header("Server","cloudflare").
		body("userId", equalTo(7),
				"title",equalTo("esse et quis iste est earum aut impedit"),
				"completed", equalTo(false));
						
		
	}

}
