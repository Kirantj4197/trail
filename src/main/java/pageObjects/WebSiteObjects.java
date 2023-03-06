package pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class WebSiteObjects  extends AbstractComponents {
	
	WebDriver driver;
	String[] allKarigal;
	int count=0;
	
	
	public WebSiteObjects(WebDriver driver)
	{   super(driver);
		this.driver=driver;
		PageFactory.initElements (driver,this);
		
	}
	
	@FindBy(xpath="//div/h4")
	List<WebElement> karigal;
	
	@FindBy(css="a[class='cart-icon']")
	WebElement cartIcon;
	
	@FindBy(xpath="//button[text()='PROCEED TO CHECKOUT']")
	WebElement checkout;
	
	@FindBy(css="input[class='promoCode']")
	WebElement promoField;
	
	@FindBy(css="button[class='promoBtn']")
	WebElement applyButton;
	
	@FindBy(xpath="//button[text()='Place Order']")
	WebElement placeOrder;
	
	
	By code=By.xpath("//span[text()='Code applied ..!']");
	
	
	public void gettingToWeb()
	{
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}
	
	public void  addingThings(String kaiKarigal,String promo)
	
	{
		
		allKarigal=kaiKarigal.split(",");
		
		for(WebElement thodakkam:karigal)
			
		{
			List<String>al=Arrays.asList(allKarigal);
			
			String firstDraft=thodakkam.getText().split("-")[0];
			String formattedString=firstDraft.substring(0, firstDraft.length()-1);
			System.out.println(formattedString);
			if(al.contains(formattedString))
			{
				
				thodakkam.findElement(By.xpath("following-sibling::div/button[text()='ADD TO CART']")).click();
				count++;
				
				}
			if(allKarigal.length==count)
			{
				break;
			}
			
		}
		
		cartIcon.click();
		checkout.click();
		promoField.sendKeys(promo);
		applyButton.click();
		waitingLogic(code);
		placeOrder.click();
	}
	
	

}
