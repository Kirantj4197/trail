package testComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.AirIndiaLandingPage;
import pageObjects.EspnCricInfoPage;
import pageObjects.FramesPageObjects;
import pageObjects.GreenKartObjects;
import pageObjects.PracticePageObjects;
import pageObjects.WebSiteObjects;

public class BaseTest {

	public WebDriver driver;
	public Properties pro;
	public AirIndiaLandingPage aip;
	public EspnCricInfoPage ec;
	public FramesPageObjects fp;
	public PracticePageObjects pp;
	public GreenKartObjects gk;
	public WebSiteObjects wb;

	public WebDriver starting() throws IOException {

		FileInputStream fin = new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\resources\\info.properties");
		pro = new Properties();
		pro.load(fin);

		String proBr = pro.getProperty("browser");
		String mvnBro = System.getProperty("browser");

		String browser = mvnBro!= null?mvnBro:proBr;

		if (browser.contains("chrome")) {
			WebDriverManager.chromiumdriver().setup();
			driver = new ChromeDriver();

		}

		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();

		return driver;

	}

	public String getScreenshot(WebDriver driver, String method) throws IOException {

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String vaali = System.getProperty("user.dir") +"//reports//"+ method + ".png";
		File file = new File(vaali);
		FileUtils.copyFile(src, file);
		return vaali;

	}

	public List<HashMap<String, String>> getJson(String pat) throws IOException {

		String json = FileUtils.readFileToString(new File(pat), StandardCharsets.UTF_8);
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(json, new TypeReference<List<HashMap<String, String>>>() {
	      });
		return data;
	}
	
	
	public AirIndiaLandingPage takeOff() throws IOException
	{
		driver=starting();
		aip=new AirIndiaLandingPage(driver);
		aip.goTo();
		return aip;
			
	}
	
	
	
	public EspnCricInfoPage toss() throws IOException
	{
		driver=starting();
		ec=new EspnCricInfoPage(driver);
		ec.gotToCricket();
		return ec;
		
		
	}
	
	
	public FramesPageObjects frameBulding() throws IOException
	{
		driver=starting();
		fp=new FramesPageObjects(driver);
		fp.goToFrame();
		return fp;
	}
	
	
public PracticePageObjects practiceStart() throws IOException
{
	driver=starting();
	pp=new PracticePageObjects(driver);
	pp.goToRahul();
	return pp;
	
}

public GreenKartObjects greenKartTable() throws IOException
{
	
	driver=starting();
	gk=new GreenKartObjects(driver);
	gk.vegSite();
	return gk;
	
	
}


public WebSiteObjects additionToCart() throws IOException
{
	driver=starting();
	wb=new WebSiteObjects(driver);
	wb.gettingToWeb();
	return wb;
	
}
	

@AfterMethod(alwaysRun=true)
public void tearDwon()
{
	driver.close();
}
	

	
	
	
	
	
}
