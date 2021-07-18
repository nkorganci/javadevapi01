package utilities;

import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class JsonUtil {
	
	/*
	 "utilities package" is used to store useful methods
	 If in your project you need some methods to use repeatedly 
	 create a "utilities package" then create classes and put the methods in the classes.
	 */
	
	private static ObjectMapper mapper;
	
	static {
		mapper= new ObjectMapper();// De-serialization process.
	}
	
	public static <T> T convertJsonToJava(String json, Class<T> cls) {
		
		T javaObject = null;
		
		try {
			javaObject= mapper.readValue(json, cls);
		} catch (JsonParseException e) {
			System.out.println("Could not convert Json data to Java object" + e.getMessage());
		} catch (JsonMappingException e) {
			System.out.println("Could not convert Json data to Java object" + e.getMessage());

		} catch (IOException e) {
			System.out.println("Could not convert Json data to Java object" + e.getMessage());
		}
		
		return javaObject;
		
	}



//Serialization: javaobject to json

public static String convertJavaToJson(Object obj) {
	
	String jsonResult = null;
	try {
		jsonResult=mapper.writeValueAsString(obj);
	} catch (JsonGenerationException e) {
		System.out.println("Could not convert Json data to Java object" + e.getMessage());

	} catch (JsonMappingException e) {
		System.out.println("Could not convert Json data to Java object" + e.getMessage());

	} catch (IOException e) {
		System.out.println("Could not convert Json data to Java object" + e.getMessage());

	}
	return jsonResult;
}

}
