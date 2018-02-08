package com.JusDone.qa.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.DashBoardPage;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.LoginPage;
import com.JusDone.qa.Pages.RegisterPage;
import com.JusDone.qa.Util.BrowserAlertHelper;
import com.JusDone.qa.Util.TestUtil;

public class RegisterPageTest extends TestBase {

	// Creating Page Objects
	HomePage homePage;
	RegisterPage registerPage;
	DashBoardPage teamsPage;
	LoginPage loginPage;
	static TestUtil testUtil;
	BrowserAlertHelper browserAlertHelper;
	String sheetName;

	// Calling TestBase Constructor
	public RegisterPageTest() {
		super();
	}

	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		registerPage = new RegisterPage();
		loginPage = new LoginPage();
		teamsPage = new DashBoardPage();
		homePage.clickOnSignUpLogo();
	}

	@Test(priority = 1)
	public void verifyRegisterNameTest() {
		Assert.assertTrue(registerPage.verifyRegisterName());

	}

	@Test(priority = 2)
	public void verifyExistingUserBtnTest() {
		Assert.assertTrue(registerPage.verifySignInBtn());
	}

	@DataProvider
	public Object[][] VerifyValidAcctNameMsg() {
		Object data[][] = TestUtil.getTestData("ValidAcct");
		return data;
	}

	@Test(priority = 3, dataProvider = "VerifyValidAcctNameMsg", enabled = false)
	public void VerifyValidAcctNameMsgTest(String Name, String Email, String Pwd, String ConfirmPwd) {
		registerPage.VerifyValidAcctNameMsg(Name, Email, Pwd, ConfirmPwd);
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@DataProvider
	public Object[][] VerifyExistingAcctErrorMsg() {
		Object data[][] = TestUtil.getTestData("ExistingAcct");
		return data;
	}

	@Test(priority = 4, dataProvider = "VerifyExistingAcctErrorMsg")
	public void VerifyExistingAcctErrorMsgTest(String Name, String Email, String Pwd, String ConfirmPwd)
	        throws IOException {
		registerPage.VerifyExistingAcctErrorMsg(Name, Email, Pwd, ConfirmPwd);
		testUtil.takeScreenshotAtEndOfTest();
	}

	@DataProvider
	public Object[][] VerifyInvalidEmailErrorMsg() {
		Object data[][] = TestUtil.getTestData("InvalidEmail");
		return data;
	}

	@Test(priority = 5, dataProvider = "VerifyInvalidEmailErrorMsg")
	public void VerifyInvalidEmailErrorMsgTest(String Name, String Email, String Pwd, String ConfirmPwd) {
		registerPage.VerifyInvalidEmailErrorMsg(Name, Email, Pwd, ConfirmPwd);
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] VerifyPwdMatchErrorMsg() {
		Object data[][] = TestUtil.getTestData("DiffPwd");
		return data;
	}

	@Test(priority = 6, dataProvider = "VerifyPwdMatchErrorMsg")
	public void VerifyPwdMatchErrorMsgTest(String Name, String Email, String Pwd, String ConfirmPwd) {
		registerPage.VerifyPwdMatchErrorMsg(Name, Email, Pwd, ConfirmPwd);
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@DataProvider
	public Object[][] VerifyBlankErrorMsg() {
		Object data[][] = TestUtil.getTestData("BlankField");
		return data;
	}

	@Test(priority = 7, dataProvider = "VerifyBlankErrorMsg")
	public void VerifyBlankErrorMsgTest(String Name, String Email, String Pwd, String ConfirmPwd) {
		registerPage.VerifyBlankErrorMsg(Name, Email, Pwd, ConfirmPwd);
		try {
			testUtil.takeScreenshotAtEndOfTest();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// Clicking on SignIn Button and Returning to LoginPage
	@Test(priority = 8)
	public void ClickSignInButtonTest() {
		loginPage = registerPage.ClickSignInButton();
	}

	// Close the Browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
