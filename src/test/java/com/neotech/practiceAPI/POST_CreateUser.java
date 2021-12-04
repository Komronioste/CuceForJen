package com.neotech.practiceAPI;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class POST_CreateUser {

	@Test
	public void createUserTest() {

		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		RequestSpecification createUserRequest = RestAssured.given();

		// I am creating a request
		createUserRequest.header("Content-Type", "application/json");

		String payload = "{\r\n" + "    \"userName\" : \"EdgarDavids\",\r\n" + "    \"password\" : \"Edgar123@!\"\r\n"
				+ "}";

		System.out.println(payload);

		// I am adding the payload in the body of the Request
		createUserRequest.body(payload);

		// I will make a POST call
		Response postResponse = createUserRequest.when().post("/Account/v1/User");

		System.out.println("-------------");

		System.out.println("Status code is --> " + postResponse.statusCode());

		postResponse.prettyPrint();

	}
	
	@Test
	public void createUserTestShortWay()
	{
		String payload = "{\r\n" + "    \"userName\" : \"EdgarDavidsss\",\r\n" + "    \"password\" : \"Edgar123@!\"\r\n"
				+ "}";
		
		RestAssured.baseURI = "https://bookstore.toolsqa.com";
		
	 Response response = RestAssured.given()
		.header("Content-Type", "application/json")
		.body(payload)
		.when().post("/Account/v1/User");
	 
	 response.prettyPrint();
	
	}

}
