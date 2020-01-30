package com.sharebox.api.tests;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

import com.sharebox.api.utils.ShareBoxUtil;
import com.sharebox.api.utils.PropertyReader;

import io.restassured.response.Response;

public class APITests {

	private static final String token1 = PropertyReader.getProperty("token1");
	
	@Test (invocationCount = 2)
	public void uploadFileTest() throws Exception {
		
//		Response resp = ShareBoxUtil.getFileDetails(token1, "da0f770c-4b1a-4e67-95d6-73a17dda6d9b");
		Response resp  = ShareBoxUtil.uploadFile("test File 123","65","30");
		String bodyResponse = resp.getBody().asString();
		int statusCode = resp.getStatusCode();
		System.out.println(statusCode + "  "+bodyResponse);
		
		assertTrue(statusCode == 200, "File Successfully Uploaded");
		
//		ShareBoxUtil.updateStatusOfFile("","");
	}
}
