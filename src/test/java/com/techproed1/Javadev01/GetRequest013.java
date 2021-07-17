package com.techproed1.Javadev01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import pojos.Data;
import pojos.Employees;
import testbaseclasses.TestBaseDummyRestapi;

public class GetRequest013 extends TestBaseDummyRestapi{
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

	
	
	
}
