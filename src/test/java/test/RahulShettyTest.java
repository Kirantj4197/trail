package test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.PracticePageObjects;
import testComponents.BaseTest;

public class RahulShettyTest extends BaseTest {
	
	PracticePageObjects pp;
	
	@BeforeMethod(alwaysRun=true)
	public void testing() throws IOException
	{
		
		pp=practiceStart();
		
	}
	
	
	@Test
	public void webdriverScope()
	{
		pp.driverScope();
	}
	
	@Test
	public void openLinks()
	{
		pp.openingNewLinks();
	}
	
	@Test
	public void broken() throws MalformedURLException, IOException
	{
		pp.brokenLinks();
		
	}
	

}
