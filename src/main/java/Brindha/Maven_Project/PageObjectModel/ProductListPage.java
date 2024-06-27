package Brindha.Maven_Project.PageObjectModel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Brindha.Maven_Project.PageObjectModel.AbstractComponents.AbstractUtilities;

public class ProductListPage extends AbstractUtilities {

WebDriver driver;
	public ProductListPage(WebDriver driver)
    {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//PageFactory

	//List of WebElements
	@FindBy(css=".mb-3")
	List<WebElement> products;
	
	//for Animation
	@FindBy(css=".ng-animating")
	WebElement animation;
	

	By ProductsBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By tost =By.cssSelector("#toast-container");
	//Method to GetList
	public List<WebElement> productlist()
	{
		waitforelementtoapper(ProductsBy);
		return products;
	}
	
	public WebElement getProductName(String ProductName)
	{
		WebElement prod = products.stream().filter(product-> 
		product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
		return prod;
	}
	public void addproduct(String productName2) throws InterruptedException
	{
		WebElement prod = getProductName(productName2);
		prod.findElement(addtocart).click();
		waitforelementtoapper(tost);
		waitforelementtodisapper(animation);
	
	}
	
}
