package com.x360.restAPIAssured.chain;


import org.testng.annotations.Test;
import io.restassured.response.Response;


@Test
public class SendAGetJiraIssue extends BaseChain {
	@Test(dependsOnMethods = "com.x360.restAPIAssured.chain.SendJiraCreateIssuevalidate.createIssueRequest")
	public void getRequest() {
		//RestAssured.baseURI="https://rajakumar1980.atlassian.net/rest/api/2/issue";		 
		Response res=inputReq.get(issueID);		
		System.out.println("Response Code >> "+res.getStatusCode());		
		res.then().log().all().assertThat().statusCode(200);
		System.out.println(""+res.jsonPath().get("id"));		
		
		
	}

}
