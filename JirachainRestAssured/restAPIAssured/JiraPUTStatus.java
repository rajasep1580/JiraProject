package com.x360.restAPIAssured;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileSystemUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Test
public class JiraPUTStatus {
	public void getRequestMultipleParams() {
		RestAssured.baseURI="https://rajakumar1980.atlassian.net/rest/api/2/issue/10015";
		//RestAssured.authentication=RestAssured.basic("rkumar.pte@gmail.com", "CH3J6HwEpVJQxY3MGesyEBD9");
		/*
		 * Map<String, String> allQuerryparamas=new HashMap<>();
		 * //allQuerryparamas.put("category", "Software");
		 * allQuerryparamas.put("sysparm_fields", "sys_id,category,description,number");
		 */
		File newfileBody=new File("D:\\seleniumx360\\xactus360\\src\\main\\resources\\createJira.json");
		RequestSpecification inputReq=RestAssured
				.given().auth().preemptive().basic("rkumar.pte@gmail.com", "CH3J6HwEpVJQxY3MGesyEBD9")
				.contentType(ContentType.JSON)
				//.queryParam("jql","project=\"POS\"")
				.accept(ContentType.JSON)				
				.body("{\r\n"
						+ "    \"fields\": {\r\n"
						+ "\r\n"
						+ "        \"description\": \"GGSE\"\r\n"
						+ "    }\r\n"
						+ "}");
		Response res=inputReq.put();
		res.prettyPrint();
		
		System.out.println("Response Code >> "+res.getStatusCode());
		
		res.then().log().all().assertThat().statusCode(204);
		
		
	}

}
