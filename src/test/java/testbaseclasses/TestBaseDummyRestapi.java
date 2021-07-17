package testbaseclasses;

import org.junit.Before;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class TestBaseDummyRestapi {

	protected RequestSpecification spec;
	
	@Before
	
	public void setUpData() {
		//This is done just one time and rare. No need to memorize.
		spec = new RequestSpecBuilder().
				setBaseUri("http://dummy.restapiexample.com/").
				build();
		
	}
}
