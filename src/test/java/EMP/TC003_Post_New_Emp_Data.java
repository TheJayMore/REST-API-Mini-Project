package EMP;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Base.Base;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import utilities.utils;

public class TC003_Post_New_Emp_Data extends Base{
	
	String empName = utils.getEmpName();
	String empSal = utils.getEmpSal();
	String empAge = utils.getEmpAge();

	@SuppressWarnings("unchecked")
	@BeforeClass
	void setNewEmployeeData() throws IOException, InterruptedException
	{
		logger.info("************* - Fetching Single Employee Data - ***********");
		
		RestAssured.baseURI="https://dummy.restapiexample.com/api/v1";
		httprequest = RestAssured.given();
		
		JSONObject empData = new JSONObject();
		empData.put("employee_name", empName);
		empData.put("employee_salary", empSal);
		empData.put("employee_age", empAge);
		
		httprequest.header("Content-Type","application/json");
		
		httprequest.body(empData.toJSONString());
		
		responce = httprequest.request(Method.POST,"/create");
		Thread.sleep(5000);
	}
	
	@Test
	void checkEmpData()
	{
		logger.info("************* - Fetching New Employee Data - *************");
		String responseBody = responce.getBody().asString();
		Assert.assertEquals(responseBody.contains(empName),true);
		Assert.assertEquals(responseBody.contains(empSal),true);
		Assert.assertEquals(responseBody.contains(empSal),true);
		logger.info("Response Body ----> "+responseBody);
	}
	
	@Test
	void checkStatusCode()
	{
		logger.info("************* - Checking Request Status Code - *************");
		int StatusCode = responce.getStatusCode();
		Assert.assertEquals(StatusCode, 200);
		logger.info("Status Code is---->"+StatusCode);
	}
	
	@Test
	void checkStatusLine()
	{
		logger.info("************* - Checking Request Status Line - *************");
		String StatusLine = responce.getStatusLine();
		Assert.assertEquals(StatusLine, "HTTP/1.1 200 OK");
		logger.info("Status Line is ---->"+StatusLine);
	}
	
	@Test
	void checkContentType()
	{
		logger.info("************* - Checking Content Type - *************");
		String ContentType = responce.getContentType();
		Assert.assertEquals(ContentType, "application/json");
		logger.info("Content Type is ---->"+ContentType);
	}
	
	@AfterClass
	void TearDown()throws IOException
	{
		logger.info("************* - Ending Test Case New Employee Data - ***********");
	}
}
