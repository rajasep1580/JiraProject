package com.x360.restAPIAssured.chain;



import org.testng.annotations.Test;

import io.restassured.response.Response;


public class DeleteJiraIssue extends BaseChain{
	@Test(dependsOnMethods = "com.x360.restAPIAssured.chain.PatchJiraIssue.chainJirametho")
	public void chainJirametho() {					
				
		Response res=inputReq.delete(issueID);
		res.prettyPrint();
		
		System.out.println("Response Code >> "+res.getStatusCode());
		
		res.then().log().all().assertThat().statusCode(204);
	}
}
