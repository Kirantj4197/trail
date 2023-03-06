package pageObjects;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import abstractComponents.AbstractComponents;

public class GreenKartObjects extends AbstractComponents {

	public WebDriver driver;
	List<String> ap;

	public GreenKartObjects(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void vegSite() {
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
	}

	@FindBy(xpath = "//tr/th[1]")
	WebElement firstColumn;

	@FindBy(xpath = "//tbody/tr/td[1]")
	List<WebElement> vegProducts;
	
	@FindBy(css="a[aria-label='Next']")
	WebElement nextButton;
	
	
	@FindBy(css="input[type='search']")
	WebElement serachBox;

	public void tableSortingLogic() {

		firstColumn.click();
		List<String> al = vegProducts.stream().map(s -> s.getText()).collect(Collectors.toList());

		List<String> sorted = al.stream().sorted().collect(Collectors.toList());

		Assert.assertTrue(al.equals(sorted));

	}

	public void searchingPrice() {

		firstColumn.click();
		
		do
		{
	 ap=vegProducts.stream().filter(s->s.getText().contains("Pineapple")).map(s->getVeggies(s)).collect(Collectors.toList());
	 if(ap.size()<1)
	 {
		 nextButton.click();
	 }
		}while(ap.size()<1);

	}
	
	private String getVeggies(WebElement  s) {
		// TODO Auto-generated method stub
		return s.findElement(By.xpath("following-sibling::td[1]")).getText();
	}
	
	
	

	

}
