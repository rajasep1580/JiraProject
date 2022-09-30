package com.x360.restAPIAssured;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileSystemUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class SendAPostRequest {
	public void getRequestMultipleParams() {
		RestAssured.baseURI="https://dev108355.service-now.com/api/now/table/incident";
		RestAssured.authentication=RestAssured.basic("admin", "b!q5Dt$NEXj7");
		Map<String, String> allQuerryparamas=new HashMap<>();
		//allQuerryparamas.put("category", "Software");
		allQuerryparamas.put("sysparm_fields", "sys_id,category,description,number");
		
		RequestSpecification inputReq=RestAssured
				.given()
				.queryParams(allQuerryparamas)
				.accept(ContentType.JSON);
		Response res=inputReq.post();
		res.prettyPrint();
		System.out.println("Response Code >> "+res.getStatusCode());
		
		
		
		
	}

}
