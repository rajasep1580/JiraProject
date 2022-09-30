package com.x360.restAPIAssured.chain;

import java.io.File;
import org.testng.annotations.Test;
import io.restassured.response.Response;

@Test
public class SendJiraCreateIssuevalidate extends BaseChain {
	@Test
	public void createIssueRequest() {
		//RestAssured.baseURI="https://rajakumar1980.atlassian.net/rest/api/2/issue";		
		File newfileBody=new File("D:\\seleniumx360\\xactus360\\src\\main\\resources\\createJira.json");
		 inputReq.body(newfileBody);
		 
		Response res=inputReq.post();		
		System.out.println("Response Code >> "+res.getStatusCode());		
		res.then().log().all().assertThat().statusCode(201);
		System.out.println(""+res.jsonPath().get("id"));			
		issueID=res.jsonPath().get("id");
		
	}

}
