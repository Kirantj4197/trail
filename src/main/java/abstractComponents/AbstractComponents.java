package abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	
	WebDriver driver;
	
	
	public AbstractComponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	
	public void waitingLogic(By input)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(input));
	}
	
	
	
	
	public void SelectLogic(WebElement element,String text)
	{
		Select s =new Select(element);
		s.selectByVisibleText(text);
		
	}
	
	public void scrollingLogic()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
	}
	
	public void selectingPlaceLogic(List<WebElement>idam,String fromTo)
	{
		for(WebElement oor:idam)
		{
			
			if(oor.getText().contains(fromTo))
			{
			   
				oor.click();
			}
			
		}
	}
	
	public void actionsClass(WebElement teams)
	{
		Actions a =new Actions(driver);
		a.moveToElement(teams).build().perform();
		
	}

}
