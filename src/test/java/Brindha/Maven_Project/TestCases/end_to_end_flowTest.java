package Brindha.Maven_Project.TestCases;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Brindha.Maven_Project.PageObjectModel.MyCartPage;
import Brindha.Maven_Project.PageObjectModel.OrderPage;
import Brindha.Maven_Project.PageObjectModel.PaymentPage;
import Brindha.Maven_Project.PageObjectModel.ProductListPage;
import Brindha.Maven_Project.PageObjectModel.confirmationpage;
import Brindha.Maven_Project.TestComponent.BaseClass;
import junit.framework.Assert;
public class end_to_end_flowTest extends BaseClass
{
//public String ProductName = "ZARA COAT 3";
@Test	(dataProvider ="getData")	
public void submitorder(HashMap <String,String> input) throws InterruptedException, IOException
{
	String CountryName ="india";
	String alertmsg ="THANKYOU FOR THE ORDER.";
    //landingObj variable is from parent class baseclass
	ProductListPage ProductListObj =landingObj.Login(input.get("email"),input.get("password"));
	//check if ZARA COAT 3 is there in the list , if yes then press the add to cart button
	ProductListObj.addproduct(input.get("productName"));	
	// We went to My Cart Page then check the item is there or not
	// if present click checkout button to proceed for payment
	MyCartPage cartpageObj = ProductListObj.goToCartPage();
	boolean check = (boolean) cartpageObj.checkItemAndClick(input.get("productName"));
	Assert.assertTrue(check);

    //We went to Payment page
	PaymentPage paymentpageObj = cartpageObj.checkout();
	confirmationpage confirmationobj = paymentpageObj.placeorder(CountryName);
	Thread.sleep(2000);
	String msgfrommethod=confirmationobj.verifyconfirmationpage();
	Assert.assertTrue(msgfrommethod.equalsIgnoreCase(alertmsg));
	//System.out.println("Submit order finished");
	}

@Test(dependsOnMethods = {"submitorder"}, dataProvider ="getData")	
public void validateproduct(HashMap <String,String> input)throws InterruptedException, IOException,NullPointerException
{
	System.out.println("validateproduct started");
	//landingObj variable is from parent class baseclass
	ProductListPage ProductListObj =landingObj.Login(input.get("email"),input.get("password"));
	OrderPage neworderObj = ProductListObj.goToOrderPage();
	System.out.println("validateproduct middle");
	boolean matchflag = neworderObj.verifyproduct(input.get("productName"));
	Assert.assertTrue(matchflag);
	System.out.println("validateproduct finished");
}
/* traditional old method to send data to test case
 * @DataProvider public Object[][] getData() {
 * 
 * return new Object[][]
 * {{"anshika@gmail.com","Iamking@000","ZARA COAT 3"},{"secondinn24@gmail.com",
 * "Newyear@2024","ADIDAS ORIGINAL"}}; }
 */

// providing data using hashmap concept
@DataProvider 
public Object[][] getData() throws IOException
{

   List <HashMap<String,String>> data = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\test\\java\\Brindha\\Maven_Project\\Data\\Purchaseorder.json");
    return new Object[][] {{data.get(0)},{data.get(1)}};
}

// Method to takeScreenshot

}

//HashMap<String,String> map = new HashMap<String,String>();
//map.put("email", "anshika@gmail.com");
//map.put("password","Iamking@000");
//map.put("productName","ZARA COAT 3");
//
//HashMap<String,String> map1 = new HashMap<String,String>();
//map1.put("email", "secondinn24@gmail.com");
//map1.put("password","Newyear@2024");
//map1.put("productName", "ADIDAS ORIGINAL");