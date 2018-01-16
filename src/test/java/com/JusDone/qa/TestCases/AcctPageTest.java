package com.JusDone.qa.TestCases;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.AcctPage;
import com.JusDone.qa.Pages.ErrorPage;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.RegistrationFormPage;
import com.JusDone.qa.Pages.SignUpPage;
import com.JusDone.qa.Util.TestUtil;

public class AcctPageTest extends TestBase {	
	
	HomePage homePage;
	SignUpPage signUpPage;
	RegistrationFormPage registrationFormPage;
	AcctPage  acctPage;
	ErrorPage errorPage;
	TestUtil testUtil;
	
	public AcctPageTest() {
		super();
	}
	
	//test cases should be separated -- independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void setUp() {
		
		initialization();
		testUtil = new TestUtil();
		homePage= new HomePage();
		signUpPage = new SignUpPage();
		registrationFormPage = new RegistrationFormPage();
		acctPage = new AcctPage();
		errorPage = new ErrorPage();
		homePage.clickOnSignUpLogo();
		signUpPage.clickOnSignUpPageLogo();
		registrationFormPage.ValidCreateNewAcct("s123", "s123@gmail.com", "set123", "set123");
		registrationFormPage.ClickRegisterButton();
		
	}
	
	@Test(priority=1)
	public void verifyNameWithLogoTest(){
		Assert.assertTrue(acctPage.verifyJusDoneLogo());
	}
	
	@Test(priority=2)
	public void verifyJusDoneLogoTest(){
		Assert.assertTrue(acctPage.verifyNameWithLogo());	
	}
	
	@Test(priority=3)
	public void VerifyTextTest() {
		String Actual=acctPage.VerifyText();
		Assert.assertEquals(Actual, "S\nSignup");
	}
	
	@Test(priority=4)
	public void ClickNameWithLogoButtonTest() {
		acctPage.ClickNameWithLogoButton();
	}

	@AfterMethod
	public void tearDown(){
		driver.quit();
		}

	
	
	
	}
