package test;

import java.io.IOException;
import java.util.List;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.WebSiteObjects;
import testComponents.BaseTest;

public class Veggies extends BaseTest {

	WebSiteObjects wb;
	String kaikarigal;
	String promo;

	@BeforeMethod
	public void frontEnd() throws IOException {
		wb = additionToCart();
	}

	@Test
	public void addingProductstoCart() {

		kaikarigal = pro.getProperty("veg");
		promo = pro.getProperty("promo");

		wb.addingThings(kaikarigal,promo);
	}

}
