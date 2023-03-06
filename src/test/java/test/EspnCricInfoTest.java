package test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.EspnCricInfoPage;
import testComponents.BaseTest;

public class EspnCricInfoTest extends BaseTest {
	
	EspnCricInfoPage ec;
	
	@BeforeMethod(alwaysRun=true)
	public void cricket() throws IOException
	{
		ec=toss();
		
	}
	
	
	@Test
	public void logicsOfCricket()
	{
		
		ec.implementingActions();
	}

}
