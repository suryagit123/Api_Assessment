package Api_Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
public class TC_06_PatchuserUpdate {
   
    @Test
    public void Patch()
    {
    	
    	RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
		
		 JSONObject json=new JSONObject(); 
		 json.put("name", "Qa-HCl");
		 
		  json.put("job", "QA-Automation");
		  
		  request.body(json.toJSONString());
		 
        Response response=request.patch("https://reqres.in/api/users/2");
        
          String data=response.asString();

 
          //print output
        System.out.println("JSON format***"+data);
        
        //status code
        int code=response.getStatusCode();
        System.out.println("Status Code is**"+code);
        
        //status line
        String line = response.getStatusLine();
        System.out.println("Line is:*** " + line);
        Assert.assertEquals(code, 200);
        
    }

 

}
 





     

 




	
	

