package com.JusDone.qa.TestCases;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.LoginPage;
import com.JusDone.qa.Pages.RegisterPage;
import com.JusDone.qa.Util.TestUtil;

public class HomePageTest extends TestBase {

	HomePage homePage;
	LoginPage loginPage;
	RegisterPage registrationPage;
	static TestUtil testUtil;
	Logger log = Logger.getLogger(HomePageTest.class);

	public HomePageTest() {
		super();
	}

	// test cases should be separated -- independent with each other
	// before each test case -- launch the browser and login
	// @test -- execute test case
	// after each test case -- close the browser

	@BeforeMethod
	public void setUp() {
		log.info(
		        "****************************** Starting test cases execution  *****************************************");
		initialization();
		testUtil = new TestUtil();
		homePage = new HomePage();
		loginPage = new LoginPage();
		registrationPage = new RegisterPage();

	}

	@Test(priority = 1)
	public void verifyHomePageTitleTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** JusDoneTitleTest *****************************************");

		extentTest = extentReports.startTest("verifyHomePageTitleTest");
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "jusDone", "Home page title  matched");

		log.info("****************************** ending test case *****************************************");
		log.info("****************************** JusDoneTitleTest *****************************************");

	}

	@Test(priority = 2)
	public void verifyJusDoneLogoTest() {
		log.info("****************************** starting test case *****************************************");
		log.info("****************************** JusDoneLogoTest *****************************************");

		extentTest = extentReports.startTest("verifyJusDoneLogoTest");
		Assert.assertTrue(homePage.verifyJusDoneLogo());

		log.info("****************************** starting test case *****************************************");
		log.info("****************************** JusDoneLogoTest *****************************************");

	}

	@Test(priority = 3)
	public void verifySignUpLogoTest() {
		log.info("****************************** SignUpLogoTest *****************************************");

		extentTest = extentReports.startTest("verifySignUpLogoTest");
		Assert.assertTrue(homePage.verifySignUpLogo());
	}

	@Test(priority = 4)
	public void verifyLoginLogoTest() {
		log.info("****************************** LoginLogoTest *****************************************");

		extentTest = extentReports.startTest("verifyLoginLogoTest");
		Assert.assertTrue(homePage.verifyLoginLogo());
	}

	@Test(priority = 5)
	public void verifyContactUsLogoTest() {
		log.info("****************************** ContactUsLogoTest *****************************************");

		extentTest = extentReports.startTest("verifyContactUsLogoTest");
		Assert.assertTrue(homePage.verifyContactUsLogo());
	}

	@Test(priority = 6)
	public void verifyAboutUsLogoTest() {
		log.info("****************************** AboutUsLogoTest *****************************************");

		extentTest = extentReports.startTest("verifyAboutUsLogoTest");
		Assert.assertTrue(homePage.verifyAboutUsLogo());
	}

	@Test(priority = 7)
	public void ClickOnSignupLogoTest() {
		log.info("****************************** ClickOnSignupLogoTest *****************************************");

		extentTest = extentReports.startTest("ClickOnSignupLogoTest");
		registrationPage = homePage.clickOnSignUpLogo();
	}

	@Test(priority = 8)
	public void ClickLoginBtnTest() {
		log.info("****************************** ClickLoginButton *****************************************");

		driver.navigate().back();
		extentTest = extentReports.startTest("ClickLoginBtnTest");
		loginPage = homePage.ClickLoginBtn();
	}

}