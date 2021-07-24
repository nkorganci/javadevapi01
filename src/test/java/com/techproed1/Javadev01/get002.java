package com.techproed1.Javadev01;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class get002 {
	
	/*
	 When: I sent a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001;
	 Then: Status code should be 404
	 And: Status Line should be HTTP/1.1 404 Not Found
	 And:Response body contains "Not Found"
	 And:Response body does not contain "TechProed":
	 */
	
	@Test
	public void get02() {
		
		Response response= given().when().get("https://restful-booker.herokuapp.com/booking/1001");
				response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
				
				response.prettyPrint();
				
				assertTrue(response.body().asString().contains("Not Found"));
				System.out.println(response.body().asString().contains("Not Found"));//True
				
				assertFalse(response.body().asString().contains("TechProed"));
				
	}

}
