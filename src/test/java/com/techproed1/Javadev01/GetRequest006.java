package com.techproed1.Javadev01;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.Test;
import org.testng.asserts.SoftAssert;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import testbaseclasses.TestBaseHerOkuApp;

public class GetRequest006 extends TestBaseHerOkuApp {
	/*
	 When
	 	I send a GET request to REST API URL http://restful-booker.herokuapp.com/booking
	 Then
	 	Among the data there should be someone whose first name is "Susan" and last name is "Brown"
	 */
		
	@Test
	
	public void get01() {
		/*QUERY PARAMETER: 
		 API Query parameters can be defined as the optional key-value pairs 
		 that appear after the question mark in the URL. 
		 Basically, they are extensions of the URL that are utilized to help determine 
		 specific content or action based on the data being delivered.
		 It start after ?
		 
		 https://www.amazon.com/s?k=JAVA&ref=nb_sb_noss_2
		 */

		
		//Set the URL
		spec.
			pathParam("bookingName", "booking").queryParams("firstname", "Mark",
															 "lastname", "Smith");
		
		//Set the expected data
		
		// Send the request
		
		Response response= given().spec(spec).when().get("/{bookingName}");
		response.prettyPrint();
		
		//Assert
		
		//1 Way use body()
		
//			response.
//				then().
//				assertThat().
//				statusCode(200).
//				body(
//						"firstname",Matchers.equalTo("Mark"),
//						"lastname", Matchers.equalTo("Smith"),
//						"totalprice", Matchers.equalTo(688),
//						"depositpaid",Matchers.equalTo(true),
//						"bookingdates.checkin",Matchers.equalTo("2020-03-20"));
		
		
		
	//2.Way Use JsonPath Class + Hard Assertion
	//JsonPath Class is good to navigate and assert for JSON data
			
			JsonPath json=response.jsonPath();
			
			assertEquals(200, response.getStatusCode());
		
			assertEquals("Sally", json.getString("firstname"));
			assertEquals("Ericsson", json.getString("lastname"));
			assertEquals(512, json.getInt("totalprice"));

	//3.Way: Use JsonPath class + Soft Assertion
	SoftAssert softAsssert = new SoftAssert();
	
	softAsssert.assertEquals(json.getString("firstname"), "sally");
	softAsssert.assertEquals(json.getBoolean("depositpaid"), false);
	
	
	softAsssert.assertAll();
			
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}	
	
}
