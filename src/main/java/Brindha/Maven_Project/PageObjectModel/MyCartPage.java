package Brindha.Maven_Project.PageObjectModel;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Brindha.Maven_Project.PageObjectModel.AbstractComponents.AbstractUtilities;

public class MyCartPage extends AbstractUtilities {

WebDriver driver;
	public MyCartPage(WebDriver driver)
    {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory

	//checkout button 
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;	

	//list of products
	By itemlist =By.cssSelector(".cartSection h3");
	
	public boolean checkItemAndClick(String ProductNam)
	{// We went to My Cart Page
		List <WebElement> productlist = driver.findElements(itemlist);
		boolean match = productlist.stream().anyMatch(productlist1->productlist1.getText().equalsIgnoreCase(ProductNam));
        return match;
	   
	}	
	public PaymentPage checkout()
	{
		checkoutbutton.click();
		PaymentPage paymentpageObj = new PaymentPage(driver);
		return paymentpageObj;
	}
}
