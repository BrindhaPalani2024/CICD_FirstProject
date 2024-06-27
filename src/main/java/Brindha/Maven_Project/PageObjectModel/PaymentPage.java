package Brindha.Maven_Project.PageObjectModel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Brindha.Maven_Project.PageObjectModel.AbstractComponents.AbstractUtilities;

public class PaymentPage extends AbstractUtilities {

WebDriver driver;
	public PaymentPage(WebDriver driver)
    {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory

	//checkout button 
	@FindBy(xpath="(//button[contains(@class,'ta-item')])[2]")
	WebElement itemlist;
	
	// Place order button
	@FindBy(css=".action__submit")
	WebElement placeorder;
	
	//Country dropdown
	@FindBy(css="[placeholder='Select Country']")
	WebElement dropdown;
	
	//Alert Message
    @FindBy(css=".hero-primary")
    WebElement alertmsg;
	//list of countries
	By itemresult = By.cssSelector(".ta-results");
	
	public confirmationpage placeorder(String countryName) {

        // We went to Payment page
		Actions a = new Actions(driver);
		//Enter country name in the dropdown
	    a.sendKeys(dropdown,countryName).build().perform();
	    waitforelementtoapper(itemresult);
	    // select the country specified
	    itemlist.click();
	    //click the place order button
	    placeorder.click();
        return new confirmationpage(driver);
	    
}
}
