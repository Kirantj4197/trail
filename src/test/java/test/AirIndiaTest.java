package test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.AirIndiaLandingPage;
import testComponents.BaseTest;

public class AirIndiaTest extends BaseTest {
	
	AirIndiaLandingPage aip;
	
	@BeforeMethod
	public void flight() throws IOException
	{
		aip=takeOff();
		
	}
	
	
	
	@Test(dataProvider="getData")
	public void ticketBooking(HashMap<String,String>input)
	{
		 
		 
		 aip.givingTravelDetails( input.get("fromKey"), input.get("from"),input.get("toKey"),input.get("to"));
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		List<HashMap<String,String>> data= getJson(System.getProperty("user.dir")+"\\src\\test\\java\\testData\\details.json");
		
		return new Object[][]  { {data.get(0)}, {data.get(1)} };
	}

}
