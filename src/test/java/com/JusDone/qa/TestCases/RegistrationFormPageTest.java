package com.JusDone.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.RegistrationFormPage;
import com.JusDone.qa.Pages.SignUpPage;
import com.JusDone.qa.Pages.AcctPage;
import com.JusDone.qa.Util.TestUtil;

public class RegistrationFormPageTest extends TestBase {
	

	HomePage homePage;
	SignUpPage signUpPage;
	RegistrationFormPage registrationFormPage;
	AcctPage  acctPage;
	TestUtil testUtil;
	String sheetName = "SignUpTestData";

	public RegistrationFormPageTest() {
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
		homePage.clickOnSignUpLogo();
		signUpPage.clickOnSignUpPageLogo();
		}
	
	/*	@Test(priority=1)
		public void ClickSignupButtons() {
		homePage.clickOnSignUpLogo();
		signUpPage.clickOnSignUpPageLogo();
		}*/
		
		@Test(priority=1)
		public void verifyRegisterFormJDPageLogoTest(){
		Assert.assertTrue(registrationFormPage.verifyRegisterFormJDPageLogo());
			
		}
		
		@Test(priority=2)
		public void  verifyRegisterFormSignUpLogo(){
		Assert.assertTrue(registrationFormPage.verifyRegisterFormSignUpLogo());
		}
		
		@DataProvider
		public  Object[][] getJusDoneTestData(){
			Object data[][] = TestUtil.getTestData(sheetName);
			return data;
		}
		
		@Test(priority=3, dataProvider="getJusDoneTestData")
		public void ValidCreateNewAcct(String Name,  String Email, String Pwd, String ConfirmPwd) {
			registrationFormPage.ValidCreateNewAcct(Name, Email, Pwd, ConfirmPwd);
			acctPage = registrationFormPage.ClickRegisterButton();
		}
		@Test(priority=4)
		public void ClickRegisterButtonTest() {
			//testUtil.ExplicitWait();
			acctPage = registrationFormPage.ClickRegisterButton();
			}
		
		@AfterMethod
		public void tearDown(){
		driver.quit();
			}

	
}
