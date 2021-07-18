package com.techproed1.Javadev01;

import org.junit.Test;

import io.restassured.response.Response;
import testbaseclasses.TestBaseJsonPlaceHolder;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import static io.restassured.RestAssured.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import pojos.Todos;

public class PutRequest01  extends TestBaseJsonPlaceHolder {
	
	/*
 	When
 		I send PUT Request to the Url https://jsonplaceholder.typicode.com/todos/198
 		with the PUT Request body like {
									    "userId": 21,
									    "title": "Wash the dishes",
									    "completed": false
									   }
   Then 
   	   Status code is 200
   	   And response body is like  {
								    "userId": 21,
								    "title": "Wash the dishes",
								    "completed": false,
								    "id": 198
								  }
 */
	/*
	 * 
	 Put Request needs:
	 1-Put Method
	 2-URL
	 3-Data
	 
	 */
	
	@Test
	public void put01() {
		
		//1 Set the URL
		spec.pathParams("todos", "todos", 
				        "id", 198);
		
		//2 Set the request body
		Todos putReqBody = new Todos(21, "Wash the dishes", false);
		
		//3 Send Put Request
		Response response = given()
						.contentType(ContentType.JSON)
						.spec(spec).body(putReqBody)
					.when()
						.put("/{todos}/{id}");
		response.prettyPrint();
		
		//Assertion
		Todos actualData = response.as(Todos.class);
		System.out.println(actualData);
		
		assertEquals(putReqBody.getUserId(), actualData.getUserId());
		assertEquals(putReqBody.getTitle(), actualData.getTitle());
		assertEquals(putReqBody.getCompleted(), actualData.getCompleted());
	
}
}
