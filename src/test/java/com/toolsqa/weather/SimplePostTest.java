package com.toolsqa.weather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimplePostTest {
	
//	@Test
//	public void postUserDetails() {
//		
//		RestAssured.baseURI = "http://restapi.demoqa.com";
//		
//		RequestSpecification req = RestAssured.given().header("Content-Type", "application/json");
//		
//		Response res = req.body(" {\n" + 
//				"   \"FirstName\": \"Pradip\",\n" + 
//				"   \"LastName\": \"Pack\",\n" + 
//				"   \"UserName\": \"pradip12232346\",\n" + 
//				"   \"Password\": \"password1\",\n" + 
//				"   \"Email\":  \"test12332225@gmail.com\"\n" + 
//				" }").when().post("/customer/register");
//		
//		System.out.println(res.asString());
//		
//		JsonPath js = res.jsonPath();
//		
//		int statusCode = res.getStatusCode();
//		
//		Assert.assertEquals(statusCode, 201, "Incorrect status code returned :");
//		
//		Assert.assertEquals(js.get("SuccessCode"), "OPERATION_SUCCESS", "Incorrect success code returned :");
//		
//		Assert.assertEquals(js.get("Message"), "Operation completed successfully", "incorrect message returned :");
//	
//	}

}
