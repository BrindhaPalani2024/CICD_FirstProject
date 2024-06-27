package Brindha.Maven_Project.PageObjectModel.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Brindha.Maven_Project.PageObjectModel.MyCartPage;
import Brindha.Maven_Project.PageObjectModel.OrderPage;

public class AbstractUtilities {

	public WebDriver driver;

	public AbstractUtilities(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	//cart Button in productlistpage
	@FindBy(css="[routerlink*='cart']")
	WebElement cart;
	
	//Order button 
	@FindBy(css="[routerlink*='myorders']")
	WebElement orderbutton;
	
	public void waitforelementtoapper(By findby)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	public void waitforwebelementtoapper(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5)); 
		wait.until(ExpectedConditions.visibilityOf(element));
	}
   public void waitforelementtodisapper(WebElement element) throws InterruptedException
   {
	   Thread.sleep(2000);
	   //WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(4)); 
	   //wait.until(ExpectedConditions.invisibilityOf(element));
   }
   public MyCartPage goToCartPage()
   {
	   // click the cart button to navigate to cart page
		cart.click();
		MyCartPage cartpageObj = new MyCartPage(driver);
		return cartpageObj;
   }
   public OrderPage goToOrderPage()
   {
	   orderbutton.click();
	   OrderPage orderpageObj = new OrderPage(driver);
	   return orderpageObj;
   }
}


