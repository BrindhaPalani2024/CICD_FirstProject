package Brindha.Maven_Project.PageObjectModel;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Brindha.Maven_Project.PageObjectModel.AbstractComponents.AbstractUtilities;

public class OrderPage extends AbstractUtilities {

WebDriver driver;
	public OrderPage(WebDriver driver)
    {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory

	//checkout button 
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;	

	//checkout button 
	@FindBy(css="tr td:nth-child(3)")
	private List<WebElement> productlist;
	
	//list of products
	By itemlist =By.cssSelector(".cartSection h3");
	
	public boolean verifyproduct(String ProductNam)
	{// We went to My Cart Page
		
		boolean match = productlist.stream().anyMatch(productlist1->productlist1.getText().equalsIgnoreCase(ProductNam));
        return match;
	   
	}	
	}
