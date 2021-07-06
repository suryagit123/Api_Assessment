package Http_Client_Api;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

 
public class Add_NewPet {
	    
	    private static String REQUEST_PAYLOAD = "{\"id\": 201,\"category\": {\"id\": 2567,\"name\": \"jillu\"},\"name\": \"doggie-snoopy\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"tagName\"}],\"status\": \"available\"}";
	 
	    @Test
	    public void addnewpet() throws ClientProtocolException, IOException {
	    	
	    	//http client
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        //http post
	        HttpPost httppost = new HttpPost("https://petstore.swagger.io/v2/pet");
	        
	        httppost.setEntity(new StringEntity(REQUEST_PAYLOAD)); // for payload   
	        
	        httppost.addHeader("Content-Type", "application/json");
	        
	        CloseableHttpResponse HttpResponse = httpClient.execute(httppost);
	        
	        System.out.println("***ADD Pet in Petstore****");
	       
	        //validating status code
	        int statusCode = HttpResponse.getStatusLine().getStatusCode();
	        System.out.println("status code is: " + statusCode);
            Assert.assertEquals(statusCode, 200);

	        
	        //validating status line
	        StatusLine line=HttpResponse.getStatusLine();
	        System.out.println("status line:"+line);
	        
	        //validating Json response
	        String response= EntityUtils.toString(HttpResponse.getEntity(), "UTF-8");
	        JSONObject responseJson = new JSONObject(response);
	        System.out.println("Response body"+responseJson);
	       
	      
	    }

	 

	}

