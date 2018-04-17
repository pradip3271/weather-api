package com.toolsqa.weather;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateHeaderResponseTest {
	
	@Test
	public void getWeatheader() {
		
		RestAssured.baseURI = "http://restapi.demoqa.com";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		Response response = httpRequest.when().get("/utilities/weather/city/Hyderabad");
		
		// Validate header response
		String contentType = response.header("Content-Type");
		System.out.println("Content-Type : " + contentType);
		
		String serverType = response.header("Server");
		System.out.println("Server Type: " + serverType);
		
		String contentEncodingType = response.header("Content-Encoding");
		System.out.println("Content-Encoding : " + contentEncodingType );
		
		// Print all header information
		
		Headers allHeader = response.headers();
		
		for(Header header : allHeader ) {
			
			System.out.println("Key : " + header.getName() + "  Value : " + header.getValue() );
		}
	}
}