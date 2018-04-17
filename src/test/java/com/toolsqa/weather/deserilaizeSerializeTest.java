package com.toolsqa.weather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class deserilaizeSerializeTest {

	@Test
	public void RegistrationSuccessful() {
		RestAssured.baseURI = "http://restapi.demoqa.com";

		RequestSpecification req = RestAssured.given().header("Content-Type", "application/json");

		Response res = req.body(" {\n" + "   \"FirstName\": \"Pradip\",\n" + "   \"LastName\": \"Pack\",\n"
				+ "   \"UserName\": \"pradip12232346\",\n" + "   \"Password\": \"password1\",\n"
				+ "   \"Email\":  \"test12332225@gmail.com\"\n" + " }").when().post("/customer/register");

		System.out.println(res.asString());

		ResponseBody body = res.getBody();

		// System.out.println("Response body => " + response.asString());

		if (res.statusCode() == 200) {
			// Deserialize the Response body into RegistrationFailureResponse
			RegistrationFailureResponse responseBody = body.as(RegistrationFailureResponse.class);

			// Use the RegistrationFailureResponse class instance to Assert the values of
			// Response.
			Assert.assertEquals("User already exists", responseBody.FaultId);
			Assert.assertEquals("FAULT_USER_ALREADY_EXISTS", responseBody.fault);
		} else if (res.statusCode() == 201) {
			// Deserialize the Response body into RegistrationSuccessResponse
			RegistrationSuccessResponse responseBody = body.as(RegistrationSuccessResponse.class);
			// Use the RegistrationSuccessResponse class instance to Assert the values of
			// Response.
			Assert.assertEquals("OPERATION_SUCCESS", responseBody.SuccessCode);
			Assert.assertEquals("Operation completed successfully", responseBody.Message);
		}
	}

}
