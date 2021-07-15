package testbaseclasses;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseJsonPlaceHolder {

	protected RequestSpecification spec;
	
	@Before
	
	public void setUp() {
		//This is done just one time and rare. No need to memorize.
		spec = new RequestSpecBuilder().
				setBaseUri("https://jsonplaceholder.typicode.com").
				build();
		
	}
}
