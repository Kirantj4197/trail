package test;

import java.io.IOException;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.GreenKartObjects;
import testComponents.BaseTest;

public class GreenKartTest extends BaseTest {
	
	GreenKartObjects gk;
	
	@BeforeMethod()
	public void veg() throws IOException
	{
		gk= greenKartTable();
	}
	
	
	
	@Test
	public void vegetable()
	{
		gk.tableSortingLogic();
	}
	
	@Test
	public void vegetablePrice()
	{
		gk.searchingPrice();
	}


}
