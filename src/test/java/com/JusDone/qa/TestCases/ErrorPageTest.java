package com.JusDone.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.AcctPage;
import com.JusDone.qa.Pages.ErrorPage;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.LoginPage;
import com.JusDone.qa.Pages.RegistrationFormPage;
import com.JusDone.qa.Pages.SignUpPage;
import com.JusDone.qa.Util.TestUtil;

public class ErrorPageTest extends TestBase {
	
	HomePage homePage;
	SignUpPage signUpPage;
	RegistrationFormPage registrationFormPage;
	AcctPage  acctPage;
	ErrorPage errorPage;
	LoginPage loginPage;
	TestUtil testUtil;
	
	public ErrorPageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeTest
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		homePage= new HomePage();
		signUpPage = new SignUpPage();
		registrationFormPage = new RegistrationFormPage();
		acctPage = new AcctPage();
		errorPage = new ErrorPage();
		loginPage= new LoginPage();
	}
	
	@Test(priority=1)
	public void ClickButtons() {
		
		homePage.clickOnSignUpLogo();
		signUpPage.clickOnSignUpPageLogo();
		registrationFormPage.ValidCreateNewAcct("s123", "s123@gmail.com", "set123", "set123");
		registrationFormPage.ClickRegisterButton();
		acctPage.ClickNameWithLogoButton();
		
	}
	
	@Test(priority=2)
	public void VerifyErrorMsgTest() {
		String Actual = errorPage.VerifyErrorMsg();
		Assert.assertEquals(Actual, "The email has already been taken.");
	}
	
	@Test(priority=3)
	public void ClickJDButton() {
		homePage = errorPage.ClickJDButton();
		
	}
	
	@Test(priority=4)
	public void ClickLogin() {
	loginPage = homePage.ClickLoginBtn();
	}
	
	@AfterTest
	public void tearDown(){
		//driver.quit();
		}


}
