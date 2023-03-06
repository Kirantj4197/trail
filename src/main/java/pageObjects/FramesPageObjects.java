package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class FramesPageObjects extends AbstractComponents{
	
	
	WebDriver driver;
	
	
	public FramesPageObjects(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//li/a[text()='Frames']")
	WebElement framesLink;
	
	@FindBy(xpath="//a[text()='Nested Frames']")
	WebElement nestedFrames;
	
	@FindBy(xpath="//div[@id='content']")
	WebElement middle;
	
	@FindBy(tagName="body")
	WebElement bottom;
	
	public void goToFrame()
	{
		driver.get("https://the-internet.herokuapp.com/");
	}
	
	public void framesLogic()
	{
		framesLink.click();
		nestedFrames.click();
		
		driver.switchTo().frame("frame-top");
		driver.switchTo().frame("frame-middle");
		System.out.println(middle.getText());
		driver.switchTo().defaultContent();
		driver.switchTo().frame("frame-bottom");
	System.out.println(bottom.getText());
		
		
	}

}
