package Brindha.Maven_Project.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Brindha.Maven_Project.PageObjectModel.AbstractComponents.AbstractUtilities;

public class LandingPage extends AbstractUtilities {
WebDriver driver;
	public LandingPage(WebDriver driver)
    {
		
			super(driver);
			this.driver = driver;
			PageFactory.initElements(driver, this);
	}
	//PageFactory
	//new changes
	//Usermail id
	@FindBy(id="userEmail")
    WebElement usermail;
	
	//Password
	@FindBy(id="userPassword")
	WebElement password;
	
	//Login Button
	@FindBy(id="login")
	WebElement LoginButton;
	
	//Error message
	@FindBy(css="div[aria-label='Incorrect email or password.']")
	WebElement Errormsg;
		
	//Method to Login
	public ProductListPage Login(String userid,String pwd)
	{
	usermail.sendKeys(userid);	
	password.sendKeys(pwd);
	LoginButton.click();
	ProductListPage ProductListObj = new ProductListPage(driver);
	return ProductListObj;
	}
	
	//Method to Navigate to LandingPage
	public void GoTo()
	{
		driver.get("https://rahulshettyacademy.com/client");
		driver.manage().window().maximize();
	}
	
	//Get errormessage
	public String geterrormessage()
	{
		waitforwebelementtoapper(Errormsg);
		return Errormsg.getText();
	}
}
