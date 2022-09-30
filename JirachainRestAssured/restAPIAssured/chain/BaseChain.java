package com.x360.restAPIAssured.chain;

import org.testng.annotations.BeforeMethod;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseChain {
	
	public static String issueID;
	public static RequestSpecification inputReq;
	@BeforeMethod
	public void test() {
		RestAssured.baseURI="https://rajakumar1980.atlassian.net/rest/api/2/issue";	
		inputReq=RestAssured
				.given().auth().preemptive().basic("rkumar.pte@gmail.com", "CH3J6HwEpVJQxY3MGesyEBD9")
				.contentType(ContentType.JSON)				
				.accept(ContentType.JSON)	;
			}

}
