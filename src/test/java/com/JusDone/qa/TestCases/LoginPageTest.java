package com.JusDone.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.DashBoardPage;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.LoginPage;
import com.JusDone.qa.Util.TestUtil;

public class LoginPageTest extends TestBase {

	// Creating a variable for Pages
	HomePage homePage;
	LoginPage loginPage;
	DashBoardPage teamsPage;
	static TestUtil testUtil;

	// Calling the TestBase Constructor
	public LoginPageTest() {
		super();
	}

	// Calling TestBase Functions and Creating Page Objects
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
		teamsPage = new DashBoardPage();
		homePage.ClickLoginBtn();
	}

	// Verifying LoginName is Displayed
	@Test(priority = 1)
	public void verifyLoginNameTest() {
		extentTest = extentReports.startTest("verifyLoginNameTest");
		Assert.assertTrue(loginPage.verifyLoginName());
	}

	// Verifying ForgotPwd is Enabled
	@Test(priority = 2)
	public void verifyLForgotPwdTest() {
		extentTest = extentReports.startTest("verifyLForgotPwdTest");
		Assert.assertTrue(loginPage.verifyLForgotPwd());
	}

	// Verifying LoginBtn is Enabled
	@Test(priority = 3)
	public void verifyLoginBtnTest() {
		extentTest = extentReports.startTest("verifyLoginBtnTest");
		Assert.assertTrue(loginPage.verifyLoginBtn());
	}

	// Verifying RememberMe is Selected
	@Test(priority = 4)
	public void verifyLRememberMeTest() {
		extentTest = extentReports.startTest("verifyLRememberMeTest");
		Assert.assertTrue(loginPage.verifyLRememberMe());
	}

	// Verifying CreateAcctBtn is Enabled
	@Test(priority = 5)
	public void verifyLCreateAcctBtnTest() {
		extentTest = extentReports.startTest("verifyLCreateAcctBtnTest");
		Assert.assertTrue(loginPage.verifyLCreateAcctBtn());
	}

	// Entering Registered Account Values
	@Test(priority = 6)
	public void ValidLoginTest() {
		// driver.navigate().back();
		// homePage.ClickLoginBtn();
		extentTest = extentReports.startTest("ValidLoginTest");
		teamsPage = loginPage.ValidLogin(prop.getProperty("EmailId"), prop.getProperty("Pwd"));
	}

	// Entering Invalid Values
	@Test(priority = 7)
	public void InvalidLoginTest() {
		// driver.navigate().back();
		// homePage.ClickLoginBtn();
		extentTest = extentReports.startTest("InvalidLoginTest");
		loginPage = loginPage.InvalidLogin("shmadam@gmail.com", "Test21");
	}

	// Leaving UserName field Blank
	@Test(priority = 8)
	public void BlankInputLoginTest() {
		extentTest = extentReports.startTest("BlankInputLoginTest");
		loginPage = loginPage.BlankInputLogin("", "Test123");
	}

}