package Brindha.Maven_Project.TestCases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import Brindha.Maven_Project.TestComponent.BaseClass;
import Brindha.Maven_Project.TestComponent.retry;

public class ErrorValidationTest extends BaseClass
{

	@Test(retryAnalyzer=retry.class)
	public void loginerrorvalidation()
	{
		//String ProductName = "ZARA COAT 3";
		
	    //landingObj variable is from parent class baseclass
		landingObj.Login("anshika@gmail.com","iamking@00990");
		assertEquals("Incorrect emaill or password.", landingObj.geterrormessage());
	}
}
