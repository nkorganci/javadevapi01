package com.techproed1.Javadev01;

import org.junit.Test;
import org.testng.asserts.SoftAssert;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;



public class GetRequest002 {
	
	/*
	 When: I sent a GET request to REST API URL https://restful-booker.herokuapp.com/booking/1001;
	 Then: Status code should be 404
	 And: Status Line should be HTTP/1.1 404 Not Found
	 And:Response body contains "Not Found"
	 And:Response body does not contain "TechProed":
	 */

		@Test
		public void get01() {
			
			//1.Set URL
			String url = "https://restful-booker.herokuapp.com/booking/1001";
			
			//2. Expected data
			
			//3.Send Request
			Response response = given().accept("application/JSON").when().get(url);
			response.prettyPrint();
			//4.Make assertion
			//Java stops execution in first failure. This is "Hard Assertion"
			response.then().assertThat().statusCode(404).statusLine("HTTP/1.1 404 Not Found");
			
//			System.out.println("=================");
			assertTrue("Asserting not found",response.asString().contains("Not Found"));//nOTE CAN BE WRITTEN
			assertFalse(response.asString().contains("TecProEd"));
			
			//Execute all assertion even some of them fails. This is called "Soft Assertion"
			
			//HOw to do "Soft Assertion"
			//a) Create SoftAssert Object
			SoftAssert softAssert = new SoftAssert();
			
			//b) Use assertion with SoftAssert object
			System.out.println("=================");
			softAssert.assertTrue(response.asString().contains("Not Found"));
			System.out.println("=================");
			softAssert.assertFalse(response.asString().contains("TEchProED"));
			System.out.println("=================");
			
			
		softAssert.assertAll();
			
			
		}
}
