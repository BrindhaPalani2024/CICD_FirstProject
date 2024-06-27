 package Brindha.Maven_Project.StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import Brindha.Maven_Project.PageObjectModel.LandingPage;
import Brindha.Maven_Project.PageObjectModel.MyCartPage;
import Brindha.Maven_Project.PageObjectModel.PaymentPage;
import Brindha.Maven_Project.PageObjectModel.ProductListPage;
import Brindha.Maven_Project.PageObjectModel.confirmationpage;
import Brindha.Maven_Project.TestComponent.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import junit.framework.Assert;

public class stepdefinition extends BaseClass{

	//Global Variables declarations
	public LandingPage landingPageObj ;
	public ProductListPage ProductListObj;
	public MyCartPage cartpageObj;
	public PaymentPage paymentpageObj;
	public confirmationpage confirmationobj;
	public String msgfrommethod;
	
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		landingPageObj =launchApplication();
	}
	
	@Given("^Logged in with username (.+) and (.+)$")
	public void logged_in_username_and_password(String username,String password)
	{
		ProductListObj = landingPageObj.Login(username,password);
	}
	@When("^I add product (.+) to cart")
	public void I_add_Product(String productName) throws InterruptedException
	{
		ProductListObj.addproduct(productName);
	}
	@And("^checkout (.+) and submit the order$")
	public void checkproduct_and_click(String productName)
	{
		cartpageObj=ProductListObj.goToCartPage();
		boolean check = (boolean) cartpageObj.checkItemAndClick(productName);
		Assert.assertTrue(check);

	    //We went to Payment page
		paymentpageObj= cartpageObj.checkout();
		confirmationobj = paymentpageObj.placeorder("india");
		
	}
	@Then("{string} the message is displayed on confirmation page")
	public void message_displayed_on_confirmation_page(String string)
	{
		msgfrommethod=confirmationobj.verifyconfirmationpage();
		Assert.assertTrue(msgfrommethod.equalsIgnoreCase(string));
		driver.close();
	}
	@Then("^\"([^\"]*)\" message on login page$")
	public void error_message_displayed_on_confirmation_page(String string1)
	{
	assertEquals(string1, landingPageObj.geterrormessage());
    driver.close();
	}
}
