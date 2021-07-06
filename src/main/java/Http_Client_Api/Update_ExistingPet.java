package Http_Client_Api;

import java.io.IOException;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

 
public class Update_ExistingPet {
	    
	    private static String REQUEST_PAYLOAD = "{\"id\": 256789,\"category\": {\"id\": 25678,\"name\": \"jillu update\"},\"name\": \"jillu-snoopy\",\"photoUrls\": [\"string\"],\"tags\": [{\"id\": 0,\"name\": \"tagName\"}],\"status\": \"available\"}";
	
	    @Test
	    public void updatepet() throws ClientProtocolException, IOException {
	    	
	    	//http client
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        //http put
	        HttpPut httpput = new HttpPut("https://petstore.swagger.io/v2/pet");
	        
	        httpput.setEntity(new StringEntity(REQUEST_PAYLOAD)); // for payload               
	        httpput.addHeader("Content-Type", "application/json");
	        CloseableHttpResponse HttpResponse = httpClient.execute(httpput);
	        
	        System.out.println("***********Update existing pet*****************");
	       
	        //validating status code
	        int statusCode = HttpResponse.getStatusLine().getStatusCode();
	        System.out.println("status code is: " + statusCode);
            Assert.assertEquals(statusCode, 200);
            
	        //validating status line
	        StatusLine line=HttpResponse.getStatusLine();
	        System.out.println("status line:"+line);
	        
	        //validating Json response body
	        String response = EntityUtils.toString(HttpResponse.getEntity(), "UTF-8");
	        JSONObject responseJson = new JSONObject(response);
	        System.out.println("Response body"+responseJson);
	    }

	}

