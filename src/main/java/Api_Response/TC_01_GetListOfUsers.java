package Api_Response;



import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC_01_GetListOfUsers {

	
	@Test
	public void get() {
		
	Response status=	
			RestAssured.get("https://reqres.in/api/users?page=2");
	
	//as string method
	String data= status.asString();
	
	//prettyprint method
	status.prettyPrint();
	
   System.out.println("JSON format"+data);
    
    //status code
    int code=status.getStatusCode();
    System.out.println("****Status code***"+status.getStatusCode());
   
    //status line
    String line = status.getStatusLine();
    System.out.println("***Line is***"+line);
    Assert.assertEquals(code, 200);   
	
	
	}
	
}
