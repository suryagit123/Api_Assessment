package Http_Client_Api;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.testng.Assert;
import org.testng.annotations.Test;


public class FindPetby_Status {

	
	 @Test
	    public void findpet_status() throws ClientProtocolException, IOException {
	    	
	    	//http client
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        //http get
	        HttpGet httpget = new HttpGet("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
	      
	        httpget.addHeader("Content-Type", "application/json");
	        CloseableHttpResponse HttpResponse = httpClient.execute(httpget);
	        
	        System.out.println("***********Find pet by status*****************");
	       
	        
	        //validating Json response 
	        String responseString = EntityUtils.toString(HttpResponse.getEntity(), "UTF-8");
	        
	       JSONArray responseJson=new JSONArray(responseString);
	     
	       System.out.println("Response body"+responseJson.toString(1));
	        
	        //validating status code
	        int statusCode = HttpResponse.getStatusLine().getStatusCode();
	        System.out.println("status code is: " + statusCode);
            Assert.assertEquals(statusCode, 200);

	        
	        //validating status line
	        StatusLine line=HttpResponse.getStatusLine();
	        System.out.println("status line:"+line);
	        
	        //Total pets
	     int count=   responseJson.length();
	     System.out.println("***Total number of pet is**" + count);
	        
	     
			/*
			 * //Headers
			 * 
			 * org.apache.http.Header[] headers= HttpResponse.getAllHeaders();
			 * HashMap<String,String> hmap=new HashMap<String,String>();
			 * for(org.apache.http.Header header: headers) {
			 * 
			 * hmap.put(header.getName(), header.getValue());
			 * 
			 * } System.out.println("****Headers is***"+hmap);
			 */
	 }}

