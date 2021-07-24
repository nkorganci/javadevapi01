package com.techproed1.Javadev01;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

import org.junit.Test;

public class Get001 {
	
	/*
	 given()
	 When: I send a GET request to the URL https://restful-booker.herokuapp.com/booking/3
	 Then: HTTP Status code should be 200
	 And:Content type should be JSON
	 And: Status Line should be HTTP/1.1 200 OK
	 */
	
	
	@Test
	public void get01() {
		
	// 1.Set the url
		String url = "https://restful-booker.herokuapp.com/booking/3";
	// 2.Expected data
	// 3.Send request
		
	Response response=given().when().get(url);
	
	response.then().assertThat().statusCode(200).contentType(ContentType.JSON).statusLine("HTTP/1.1 200 OK");
	
	response.prettyPrint();
	
		
	}
	


}
