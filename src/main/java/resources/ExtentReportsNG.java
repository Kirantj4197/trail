package resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportsNG {
	
	  static ExtentReports extent;
	
	public static ExtentReports getReporting()
	{
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter=new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("ranjith");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	
		
		
	}

}
