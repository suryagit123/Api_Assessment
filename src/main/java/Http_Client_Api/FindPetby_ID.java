package Http_Client_Api;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FindPetby_ID {

	
	 @Test
	    public void findpet() throws ClientProtocolException, IOException {
	    	
	    	//http client
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        //http get
	      
	       HttpGet httpget = new HttpGet("https://petstore.swagger.io/v2/pet/201");
	        httpget.addHeader("Content-Type", "application/json");
	        CloseableHttpResponse HttpResponse = httpClient.execute(httpget);
	        
	        System.out.println("***********Find pet *****************");
	       
	        
	        //validating Json response 
	        String responseString = EntityUtils.toString(HttpResponse.getEntity(), "UTF-8");
	        JSONObject responseJson = new JSONObject(responseString);
	        System.out.println("Response body"+responseJson);
	        
	        //validating status code
	        int statusCode = HttpResponse.getStatusLine().getStatusCode();
	        System.out.println("status code is: " + statusCode);
            Assert.assertEquals(statusCode, 200);

	        
	        //validating status line
	        StatusLine line=HttpResponse.getStatusLine();
	        System.out.println("status line:"+line);
	        
	        //Total pey by id
	       System.out.println("***Total pet is**"+responseJson.length());
	        
	    
	 }}

