package pageObjects;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import abstractComponents.AbstractComponents;

public class PracticePageObjects extends AbstractComponents{
	
	WebDriver driver;
	SoftAssert a;
	
	public PracticePageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="div[id='gf-BIG']")
	WebElement footer;
	
	
	@FindBy(xpath="//tr/td/ul/li/a")
	List<WebElement> allLinks;
	
	
	public void goToRahul()
	{
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
	}
	
	public void driverScope()
	{
		int count=footer.findElements(By.xpath("//td/ul/li/a")).size();
		
		System.out.println(count);
	}
	
	public void openingNewLinks()
	{
		
		scrollingLogic();
		
		for(WebElement one:allLinks)
		{
			one.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
		}
		
		Set<String>allWindows=driver.getWindowHandles();
		
	Iterator<String>iter=	allWindows.iterator();
	
	while(iter.hasNext())
	{
		driver.switchTo().window(iter.next());
		System.out.println(driver.getTitle());
		
	}
		
	}
	
	public void brokenLinks() throws MalformedURLException, IOException
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,10000)");
		a=new SoftAssert();
	
		
		for(WebElement single:allLinks)
		{
			String url=single.getAttribute("href");
		
		HttpURLConnection con=(HttpURLConnection)new URL(url).openConnection();
		con.setRequestMethod("HEAD");
		con.connect();
		int res=con.getResponseCode();
		a.assertTrue(res<400,url+" "+"is broken");
		
	}
		a.assertAll();
	}

}
