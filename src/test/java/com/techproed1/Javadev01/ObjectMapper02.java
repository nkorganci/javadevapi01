package com.techproed1.Javadev01;

import java.util.HashMap;

import org.junit.Test;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertEquals;

import testbaseclasses.TestBaseHerOkuApp;
import utilities.JsonUtil;

public class ObjectMapper02 extends TestBaseHerOkuApp {

	/*
		When 
 		I send GET Request to the URL https://restful-booker.herokuapp.com/booking/2
 		
 	Then 
 		Status code is 200
 		And response body is like {
								    "firstname": "Mark",
								    "lastname": "Ericsson",
								    "totalprice": 726,
								    "depositpaid": true,
								    "bookingdates": {
								        "checkin": "2015-08-07",
								        "checkout": "2020-10-25"
								     }
								  }
*/
	
	
	@Test
	public void get01() {
		//1.Set the url
		spec.pathParams("booking","booking",
						"id",2);
		
		//2.Set the expected data
		String expectedJson= "{\r\n"
				+ "\"firstname\": \"Jim\",\r\n"
				+ "\"lastname\": \"Ericsson\",\r\n"
				+ "\"totalprice\": 721,\r\n"
				+ "\"depositpaid\": true,\r\n"
				+ "\"bookingdates\": {\r\n"
				+ "\"checkin\": \"2019-04-08\",\r\n"
				+ "\"checkout\": \"2020-09-17\"\r\n"
				+ "}\r\n"
				+ "}";
		
		HashMap<String, Object> expectedData= JsonUtil.convertJsonToJava(expectedJson, HashMap.class);
		
		//Send the request
		Response response=given().spec(spec).when().get("/{booking}/{id}");
		HashMap<String, Object> actualData=JsonUtil.convertJsonToJava(response.asString(), HashMap.class);
		
		//Assertions
		assertEquals(expectedData.get("firstname"), actualData.get("firstname"));
		assertEquals(expectedData.get("lastname"), actualData.get("lastname"));
		assertEquals(expectedData.get("totalprice"), actualData.get("totalprice"));
		assertEquals(expectedData.get("depositpaid"), actualData.get("depositpaid"));
		
		assertEquals(((HashMap)expectedData.get("bookingdates")).get("checkin"), 
				     ((HashMap)actualData.get("bookingdates")).get("checkin"));
		
		assertEquals(((HashMap)expectedData.get("bookingdates")).get("checkout"), 
			     ((HashMap)actualData.get("bookingdates")).get("checkout"));
		
		
		//Convert actualData HashMap to Json format
		String jsonResult = JsonUtil.convertJavaToJson(actualData);
		System.out.println(jsonResult);
		
		
	}
	
	
}


