package Http_Client_Api;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deletepetby_ID {


	 @Test
	    public void deletepet() throws ClientProtocolException, IOException {
	    	
	    	//http client
	        CloseableHttpClient httpClient = HttpClients.createDefault();
	        
	        //http delete
	        HttpDelete httpdelete = new HttpDelete("https://petstore.swagger.io/v2/pet/256789");
	        httpdelete.addHeader("Content-Type", "application/json");
	        CloseableHttpResponse HttpResponse = httpClient.execute(httpdelete);
	        
	        System.out.println("***********delete pet *****************");
	       
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
