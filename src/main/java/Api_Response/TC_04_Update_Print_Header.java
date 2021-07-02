package Api_Response;


import org.testng.Assert;
import org.testng.annotations.Test;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;

public class TC_04_Update_Print_Header {
   
    @Test
    public void put_header()
    {
    	
    	RequestSpecification request=RestAssured.given();
        request.header("Content-Type","application/json");
		
		 JSONObject json=new JSONObject(); 
		 json.put("name", "TesterHCl");
		 
		  json.put("job", "AutomationTester");
		  
		  request.body(json.toJSONString());
		 
        Response response=request.put("https://reqres.in/api/users/2");
        
        
        //print header
        String data=response.asString();

        System.out.println("JSON format***"+data);
        
       
        
    }

 

}
 





     

 




	
	

