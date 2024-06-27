package Brindha.Maven_Project.TestComponent;
import java.io.File;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import Brindha.Maven_Project.PageObjectModel.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.util.HashMap;
import java.util.List;
import java.util.Properties;
public class BaseClass {
	
private static final boolean True = false;
//Variable declaration
public LandingPage landingObj;	
public WebDriver driver = null;
public WebDriver initializeDriver() throws IOException
{
	Properties prop = new Properties();
    FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\Brindha\\Maven_Project\\Resources\\GlobalData.properties");		
	prop.load(fis);
	String browsername = System.getProperty("browser")!=null?System.getProperty("browser"):prop.getProperty("browser");
	
	if(browsername.equalsIgnoreCase("chrome"))
	{
		// Setting system properties of ChromeDriver	
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();	
    }
	else if(browsername.equalsIgnoreCase("firefox"))
	{
		// Setting system properties of FirefoxDriver
		System.setProperty("webdriver.gecko.driver","C:\\Users\\Brindha\\Documents\\geckodriver.exe"); 
	    driver = new FirefoxDriver(); //Creating an object of FirefoxDriver
	}
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/client");
	driver.manage().window().maximize();
	return driver;
	}
//DataProvider Method to read JSonFile content
public List<HashMap<String, String>> getJsonDataToMap(String filepath) throws IOException
{
	//Reading Json to String
	String JsonContent = FileUtils.readFileToString(new File(filepath),StandardCharsets.UTF_8);

	//String to JSon
	ObjectMapper mapper = new ObjectMapper();
	List<HashMap<String,String>> data = mapper.readValue(JsonContent,new TypeReference <List <HashMap<String,String>>>()
			{});
	return data;
	}



//This will execute first before the test
@BeforeMethod(alwaysRun = True)
public LandingPage launchApplication() throws IOException
{
	initializeDriver();
	landingObj = new LandingPage(driver);
	landingObj.GoTo();
	return landingObj;
}
//Method to take screenshot
public String getScreenshot(String testcasename, WebDriver driver) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot)driver;
	File source = ts.getScreenshotAs(OutputType.FILE);
	File file = new File(System.getProperty("user.dir")+"//reports//"+testcasename+".png");
    FileUtils.copyFile(source,file);    
    return System.getProperty("user.dir")+"//reports//"+testcasename+".png";	
}
//This will execute at last 
@AfterMethod(alwaysRun = True)
public void teardown()
{
	driver.close();
}


}
