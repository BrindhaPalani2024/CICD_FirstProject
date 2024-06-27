package Brindha.Maven_Project.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class newExtentReporterNG {
	static ExtentReports extent;
	public static ExtentReports getExtentReporterObject()
	{
		String path = System.getProperty("user.dir")+"\\Reports\\index.html";
    	ExtentSparkReporter newextentrep = new ExtentSparkReporter(path);
        newextentrep.config().setReportName("Web Automation Results");
        newextentrep.config().setDocumentTitle("Test Results");
        extent = new ExtentReports();
        extent.attachReporter(newextentrep);
        extent.setSystemInfo("Tester","Brindha Palani");
        return extent;
	}
}
