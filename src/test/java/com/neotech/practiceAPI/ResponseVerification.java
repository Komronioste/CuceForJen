package com.neotech.practiceAPI;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class ResponseVerification {

	@Test
	public void verifyGetAllBooksRequest() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		RequestSpecification getAllBooksRequest = RestAssured.given();

		Response response = getAllBooksRequest.when().request(Method.GET, "/BookStore/v1/Books");
		
		System.out.println("---------------");
		
		response.then().assertThat().statusCode(200);
		
		int statusCode = response.statusCode();
		
		Assert.assertEquals(200, statusCode);

		System.out.println("---------------");
		
		response.then().assertThat().header("Content-Type", "application/json; charset=utf-8");
		
		System.out.println("---------------");
		
		String responseBody = response.body().asString();
		
		boolean contains = responseBody.contains("Git Pocket Guide");
		
		Assert.assertTrue(contains);
		
		

	}

}
