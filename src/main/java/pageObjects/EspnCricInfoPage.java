package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class EspnCricInfoPage extends AbstractComponents{
	
	WebDriver driver;
	
	public EspnCricInfoPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	
	
	
	@FindBy(xpath="//div/a[text()='Teams']")
	WebElement teams;
	
	
	@FindBy(xpath="//span[text()='England']")
	WebElement englandTeam;
	
	
	@FindBy(css="div[class='ds-flex ds-text-title-xs ds-items-center'] div a")
	List<WebElement>allTags;
	
	public void gotToCricket()
	{
		driver.get("https://www.espncricinfo.com/");
	}
	
	public void implementingActions()
	{
		actionsClass(teams);
		englandTeam.click();
		
		
		for(WebElement link:allTags)
		{    
			link.sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
			
		}
		Set<String>wind=driver.getWindowHandles();
		Iterator<String> iti=wind.iterator();
		while(iti.hasNext())
		{
			driver.switchTo().window(iti.next());
			System.out.println(driver.getTitle());
		}
	}
	

}
