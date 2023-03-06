package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import abstractComponents.AbstractComponents;

public class AirIndiaLandingPage extends AbstractComponents {

	WebDriver driver;

	public AirIndiaLandingPage(WebDriver driver)

	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div/input[@id='oneway']/following-sibling::ins")
	WebElement oneWay;
	
	@FindBy(css = "input[placeHolder='From']")
	WebElement fromCheckBox;
	
	@FindBy(css = "#to")
	WebElement toCheckBox;

	@FindBy(id="ddladult1")
	WebElement adultDropDown;
	
	@FindBy(xpath="//ul[@id='ui-id-2']/li/a")
	List<WebElement> fromCountries ;
	
	@FindBy(xpath="//ul[@id='ui-id-3']/li/a")
	List<WebElement> toCountries;
	
	@FindBy(id="_classType1")
	WebElement economy;
	
	@FindBy(css="input[title='Departing']")
	WebElement depart;
	
	@FindBy(xpath="(//span[@class='ui-datepicker-month'])[1]")
	WebElement month;
	
	@FindBy(xpath="//span[text()='Next']")
	WebElement nextButton;
	
	@FindBy(xpath="//td[@data-month='5']/a")
	List<WebElement> dateSelection;
	
	@FindBy(xpath="//input[@id='btnbooking']")
	WebElement searchButton;
	
	
	public void goTo() {
		driver.get("https://www.airindia.in/");
	}
	
	public void givingTravelDetails(String fromKey,String from,String toKey,String to)
	{
		scrollingLogic();
		oneWay.click();
		fromCheckBox.sendKeys(fromKey);
		selectingPlaceLogic(fromCountries,from);
		toCheckBox.sendKeys(toKey);
		selectingPlaceLogic(toCountries,to);
		depart.click();
		
		
		SelectLogic(adultDropDown,"2");
		SelectLogic(economy,"First");
		
		
		while(!month.getText().equals("June"))
		{
			nextButton.click();
		}
		
		
		for(WebElement date:dateSelection)
		{
			if(date.getText().contains("15"))
			{
				date.click();
				break;
			}
		}
		
		searchButton.click();
	}

}
