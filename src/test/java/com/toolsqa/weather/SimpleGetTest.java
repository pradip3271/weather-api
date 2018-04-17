package com.toolsqa.weather;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;



public class SimpleGetTest {
	
	@Test
	public void getWeatherDetails() {
		
		// Specify the base URL to the RESTful web service
		RestAssured.baseURI = "http://restapi.demoqa.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.when().get("/utilities/weather/city/Hyderabad");
				
		System.out.println("Response body is => " + response.asString());
		
		//Validate response status code
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200, "Incorrect status code return :");
		
		//Validate response status line
		String statusLine = response.getStatusLine();
		
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Incorrect status line return :");
		
	}

}
