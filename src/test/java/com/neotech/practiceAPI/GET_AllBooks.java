package com.neotech.practiceAPI;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class GET_AllBooks {

	public static void main(String[] args) {

		// Base URI for all API calls
		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		System.out.println(RestAssured.baseURI);

		// We are building the request
		RequestSpecification getAllBooksRequest = RestAssured.given();

		// Now we are making an actual request to the server and getting a response
//				Response allBooksResponse = getAllBooksRequest.when().get("/BookStore/v1/Books");

		// another way, 2nd way
		Response allBooksResponse = getAllBooksRequest.when().request(Method.GET, "/BookStore/v1/Books");

		System.out.println("-----------------");

		int statusCode = allBooksResponse.getStatusCode();

		System.out.println(statusCode);
		
		System.out.println("-----------------");
		
		Headers headers = allBooksResponse.getHeaders();
		
		System.out.println(headers);
		
		System.out.println("-----------------");
		
		String oneHeader = allBooksResponse.getHeader("Content-Type");
		System.out.println(oneHeader);
		
		System.out.println("-----------------");
		
		ResponseBody body = allBooksResponse.body();
		
		System.out.println(body.asString());
		System.out.println("-----------------");
		
		allBooksResponse.prettyPrint();
		
	}

}
