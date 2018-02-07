package com.JusDone.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
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
		Assert.assertTrue(loginPage.verifyLoginName());
	}

	// Verifying ForgotPwd is Enabled
	@Test(priority = 2)
	public void verifyLForgotPwdTest() {
		Assert.assertTrue(loginPage.verifyLForgotPwd());
	}

	// Verifying LoginBtn is Enabled
	@Test(priority = 3)
	public void verifyLoginBtnTest() {
		Assert.assertTrue(loginPage.verifyLoginBtn());
	}

	// Verifying RememberMe is Selected
	@Test(priority = 4)
	public void verifyLRememberMeTest() {
		Assert.assertTrue(loginPage.verifyLRememberMe());
	}

	// Verifying CreateAcctBtn is Enabled
	@Test(priority = 5)
	public void verifyLCreateAcctBtnTest() {
		Assert.assertTrue(loginPage.verifyLCreateAcctBtn());
	}

	// Entering Registered Account Values
	@Test(priority = 6)
	public void ValidLoginTest() {
		teamsPage = loginPage.ValidLogin(prop.getProperty("EmailId"), prop.getProperty("Pwd"));
	}

	// Entering Invalid Values
	@Test(priority = 7)
	public void InvalidLoginTest() {
		loginPage = loginPage.InvalidLogin("shmadam@gmail.com", "Test21");
	}

	// Leaving UserName field Blank
	@Test(priority = 8)
	public void BlankInputLoginTest() {
		loginPage = loginPage.BlankInputLogin("", "Test123");
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
