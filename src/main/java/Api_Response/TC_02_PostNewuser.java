package Api_Response;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
public class TC_02_PostNewuser {
   
    @Test
    public void Post()
    {
    	
    	RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
		
		 JSONObject json=new JSONObject(); 
		json.put("name", "Tester123");
		 
		  json.put("job", "Automation");
		  
		  request.body(json.toJSONString());
		 
        Response response=request.post(" https://reqres.in/api/users");
        
     
      //print output with json
          String data=response.prettyPrint();
          
        
        //status code
        int code=response.getStatusCode();
        System.out.println("Status Code is**"+code);
        
        //status line
        String line = response.getStatusLine();
        System.out.println("Line is: **" + line);
        Assert.assertEquals(code, 201);
        
    }

 

}
 





     

 




	
	

