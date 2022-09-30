package com.x360.restAPIAssured.chain;



import org.testng.annotations.Test;

import io.restassured.response.Response;


public class PatchJiraIssue extends BaseChain{
	@Test(dependsOnMethods = "com.x360.restAPIAssured.chain.SendJiraCreateIssuevalidate.createIssueRequest")
	public void chainJirametho() {					
				inputReq.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "\r\n"
						+ "        \"description\": \"GGSE\"\r\n"
						+ "    }\r\n"
						+ "}");
		Response res=inputReq.put(issueID);
		res.prettyPrint();
		
		System.out.println("Response Code >> "+res.getStatusCode());
		
		res.then().log().all().assertThat().statusCode(204);
	}
}
