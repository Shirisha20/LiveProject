package com.JusDone.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.RegistrationFormPage;
import com.JusDone.qa.Pages.SignUpPage;
import com.JusDone.qa.Util.TestUtil;

public class SignUpPageTest extends TestBase {

	HomePage homePage;
	SignUpPage signUpPage;
	RegistrationFormPage registrationFormPage;
	TestUtil testUtil;

	public SignUpPageTest() {
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
		homePage.clickOnSignUpLogo();
	}
	
	@Test(priority=2)
	public void verifySignUpJusDoneLogoTest(){
		Assert.assertTrue(signUpPage.verifySignUpJusDoneLogo());
	}

	@Test(priority=3)
	public void verifySignUpPageLogoTest(){
		Assert.assertTrue(signUpPage.verifySignUpPageLogo());
	}
	@Test(priority=4)
	public void clickOnSignUpPageLogoTest(){
		registrationFormPage = signUpPage.clickOnSignUpPageLogo();
		}
	@AfterMethod
	public void tearDown(){
		driver.quit();
		}


	



}
