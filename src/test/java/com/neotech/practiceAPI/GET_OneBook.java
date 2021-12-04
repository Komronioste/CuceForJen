package com.neotech.practiceAPI;

// importing all static methods from Matcher class
import static org.hamcrest.Matchers.*;

import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class GET_OneBook {

	@Test
	public void getOneBookTest() {

		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		RequestSpecification getOneBookRequest = RestAssured.given();

		getOneBookRequest.queryParam("ISBN", "9781491950296");

		Response response = getOneBookRequest.when().get("/BookStore/v1/Book");

		System.out.println("----------------");

		System.out.println("Status code is --> " + response.getStatusCode());

		response.then().assertThat().statusCode(200);

		System.out.println("----------------");

		response.prettyPrint();

		// Assertions using hamcrest.matchers.equalTo() method
		response.then().assertThat().body("title", equalTo("Programming JavaScript Applications"));

		// Assertions using hamcrest.matchers.containsString() method
		response.then().assertThat().body("subTitle", containsString("Architecture"));

		// Assertions using hamcrest.matchers.endsWith() method
		response.then().assertThat().body("author", endsWith("ott"));

	}

}
