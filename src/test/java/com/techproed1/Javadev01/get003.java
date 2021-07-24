package com.techproed1.Javadev01;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class get003 {

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
	public void get03() {
		
		Response response= given().accept(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/todos/23");
		response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
		
		response.prettyPrint();
		
		JsonPath json = response.getBody().jsonPath();
				 assertEquals(json.get("userId"),2 );
				 assertEquals(json.get("id"), 23);
				 assertEquals(json.get("title"), "et itaque necessitatibus maxime molestiae qui quas velit");
				 assertFalse(json.getBoolean("completed"));
		
	}
	
	
	
}
