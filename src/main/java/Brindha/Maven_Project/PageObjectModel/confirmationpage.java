package Brindha.Maven_Project.PageObjectModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Brindha.Maven_Project.PageObjectModel.AbstractComponents.AbstractUtilities;


public class confirmationpage extends AbstractUtilities {

WebDriver driver;
	public confirmationpage(WebDriver driver)
    {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory

    //Alert Message
    @FindBy(css=".hero-primary")
    WebElement alertmsg;
	
	public String verifyconfirmationpage() {

        // We went to confirmation page
		String strmsg = alertmsg.getText();
	    return strmsg;
}
}
