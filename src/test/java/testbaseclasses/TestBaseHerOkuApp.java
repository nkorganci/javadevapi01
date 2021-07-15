package testbaseclasses;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseHerOkuApp {

	protected RequestSpecification spec;
	
	@Before
	
	public void setUp() {
		//This is done just one time and rare. No need to memorize.
		spec = new RequestSpecBuilder().
				setBaseUri("http://restful-booker.herokuapp.com/").
				build();
		
	}
}
