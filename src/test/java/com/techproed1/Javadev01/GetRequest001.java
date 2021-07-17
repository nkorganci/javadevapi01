package com.techproed1.Javadev01;

import org.junit.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;


public class GetRequest001 {

	
	/*
	 Gherkin Language:
	 Given: Declare prerequisets
	 When:It defines the actions user will perform
	 Then: Talk about outputs
	 And: It can be used in Given, When, Then, if you have multiple options. for more readable;
	 */
	
	/*
	 When: I send a GET request to the URL https://restful-booker.herokuapp.com/booking/3
	 Then: HTTP Status code should be 200
	 And:Content type should be JSON
	 And: Status Line should be HTTP/1.1 200 OK
	 */
	
	
	//To create a test method we use test annotation which comes from junit.
	@Test
	public void get01() {
	//If you need to test an API we need to do 4steps:
		
		//1.Step: send URL
		String url = "https://restful-booker.herokuapp.com/booking/3";
		
		//2.Step: Set the expected data
		
		//3.Step: Send the request to the API
		
		Response response = given().accept("application/json").when().get(url);
		response.prettyPrint();
		
		//4.step: Make assertions
		response.then()
			.assertThat()
			.statusCode(200)
			.contentType(ContentType.JSON)
			.statusLine("HTTP/1.1 200 OK");// "application/json" is also working.
		
		//How to print content-type, status code, status line
		System.out.println("contentType: " + response.getContentType());
		System.out.println(response.getStatusCode());
		System.out.println(response.getStatusLine());
		System.out.println(response.getHeaders());
		System.out.println(response.getHeader("Date"));
		
	}
}
