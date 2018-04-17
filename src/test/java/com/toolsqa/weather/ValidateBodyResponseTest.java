package com.toolsqa.weather;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateBodyResponseTest {
	
	@Test
	public void validateBodyResponse() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response res = httpRequest.when().get("/utilities/weather/city/Hyderabad");
		
		JsonPath jp = res.jsonPath();
		
		System.out.println("City Name : "+ jp.get("City"));
		
		System.out.println("Temperature : "+ jp.get("Temperature"));
		
		
	}

}
