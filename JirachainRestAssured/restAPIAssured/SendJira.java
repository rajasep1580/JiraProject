package com.x360.restAPIAssured;

import java.util.HashMap;
import java.util.Map;


import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class SendJira {
	public void getRequestMultipleParams() {
		RestAssured.baseURI="https://rajakumar1980.atlassian.net/rest/api/2/search";
		//RestAssured.authentication=RestAssured.basic("rkumar.pte@gmail.com", "CH3J6HwEpVJQxY3MGesyEBD9");
		/*
		 * Map<String, String> allQuerryparamas=new HashMap<>();
		 * //allQuerryparamas.put("category", "Software");
		 * allQuerryparamas.put("sysparm_fields", "sys_id,category,description,number");
		 */
		
		RequestSpecification inputReq=RestAssured
				.given().auth().preemptive().basic("rkumar.pte@gmail.com", "CH3J6HwEpVJQxY3MGesyEBD9")
				.queryParam("jql","project=\"POS\"")
				.accept(ContentType.JSON);
		Response res=inputReq.get();		
		System.out.println("Response Code >> "+res.getStatusCode());
		res.then().log().all().assertThat().body("issues[0].id", Matchers.hasItem("100"));
		
		
		
		
		
	}

}
