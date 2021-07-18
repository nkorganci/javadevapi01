package com.techproed1.Javadev01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import pojos.Bookingdates;
import pojos.Bookings;
import pojos.Data;
import pojos.Employees;
import testbaseclasses.TestBaseDummyRestapi;
import testbaseclasses.TestBaseHerOkuApp;

public class GetRequest013 extends TestBaseHerOkuApp{
	/*
 	When 
 		I send GET Request to https://restful-booker.herokuapp.com/booking/1
 	Then 
 		Response body should be like that;
								 		{
										    "firstname": "Eric",
										    "lastname": "Smith",
										    "totalprice": 555,
										    "depositpaid": false,
										    "bookingdates": {
										        "checkin": "2016-09-09",
										        "checkout": "2017-09-21"
										     }
										}
*/

	
	@Test
	public void get01() {
		
		//1 Set the URL
		spec.pathParams("booking", "booking", 
						"id",1);
		
		//2 Expected Data
		
		Bookingdates bookingdates= new Bookingdates("2017-07-08", "2017-09-21");
		
		Bookings expectedData = new Bookings("Mark", "Ericsson", 411, true, bookingdates);
		
		System.out.println(expectedData);
		
		
		//3 Send request
		
		Response response = given().spec(spec).when().get("/{booking}/{id}");
		response.prettyPrint();
		
		//4 Assertion
		
		Bookings actualData= response.as(Bookings.class);
		System.out.println(actualData);
		
		assertEquals(expectedData.getFirstname(),actualData.getFirstname());
		assertEquals(expectedData.getLastname(),actualData.getLastname());
		assertEquals(expectedData.getDepositpaid(),actualData.getDepositpaid());
		assertEquals(expectedData.getTotalprice(),actualData.getTotalprice());
		
		assertEquals(expectedData.getBookingdates().getCheckin(), actualData.getBookingdates().getCheckin());
		assertEquals(expectedData.getBookingdates().getCheckout(), actualData.getBookingdates().getCheckout());
		
		
		
		
}
}