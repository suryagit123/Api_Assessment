package Api_Response;


import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class TC_03_PutuserUpdate_Status {
   
    @Test
    public void Put_status()
    {
    	
    	RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
		
		 JSONObject json=new JSONObject(); 
		 json.put("name", "TesterHCl");
		 
		  json.put("job", "AutomationTester");
		  
		  request.body(json.toJSONString());
		 
        Response response=request.put("https://reqres.in/api/users/2");
        
        
        //status code
        int code=response.getStatusCode();
        System.out.println("Status Code is***"+code);
        
        //status line
        String line = response.getStatusLine();
        System.out.println("Line is: ***" + line);
        Assert.assertEquals(code, 200);
        
    }

 

}
 





     

 




	
	

