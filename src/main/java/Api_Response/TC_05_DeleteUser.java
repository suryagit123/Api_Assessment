package Api_Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_05_DeleteUser {

	
	@Test
	public void delete_user() {
		
	Response status=	
			RestAssured.delete("https://reqres.in/api/users/2");
	
	String data = status.asString();
	
    System.out.println("JSON format****"+data);
    
    //status code
    int code=status.getStatusCode();
    System.out.println("Status code***"+code);
   
    //status line
    String line = status.getStatusLine();
    System.out.println("Line is***"+line);
    Assert.assertEquals(code, 204);   
	
	
	}
	
}
