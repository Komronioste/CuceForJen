package com.neotech.practiceAPI;

import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;

public class POST_GeneraToken {

	public static String username = "PaoloMaldini";
	public static String password = "PaoloMaldini3!!!";
	public static String userID;
	public static String token;

	@Test
	public void generateToken() {
		RestAssured.baseURI = "https://bookstore.toolsqa.com";

		String payload = "{\r\n" + "    \"userName\" : \"EdgarDavids\",\r\n" + "    \"password\" : \"Edgar123@!\"\r\n"
				+ "}";

		Response response = RestAssured.given().header("Content-Type", "application/json").body(payload).when()
				.post("/Account/v1/GenerateToken");

		response.prettyPrint();

		Headers headers = response.headers();
		System.out.println(headers);

		String body = response.body().asString();

		boolean a = (body.contains("Success")) ? true : false;

		Assert.assertTrue(a);

	}

}
