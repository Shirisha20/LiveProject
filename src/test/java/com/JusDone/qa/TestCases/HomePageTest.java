package com.JusDone.qa.TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.SignUpPage;
import com.JusDone.qa.Util.TestUtil;

public class HomePageTest extends TestBase {
	
	HomePage homePage;
	SignUpPage signUpPage;
	TestUtil testUtil;
	
	public HomePageTest() {
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
			
				}
		
@Test(priority=1)
public void verifyHomePageTitleTest(){
	String homePageTitle = homePage.verifyHomePageTitle();
	Assert.assertEquals(homePageTitle, "Laravel","Home page title not matched");
}

@Test(priority=2)
public void verifyJusDoneLogoTest(){
	Assert.assertTrue(homePage.verifyJusDoneLogo());
}

@Test(priority=3)
public void verifySignUpLogoTest(){
	/*WebDriverWait wait = new WebDriverWait(driver, 10);
	WebElement element = wait.until(
	        ExpectedConditions.visibilityOfElementLocated(By.xpath("//label[@for='c3']")));*/
	testUtil.ExplicitWait();
	Assert.assertTrue(homePage.verifySignUpLogo());
}

@Test(priority=4)
public void verifyLoginLogoTest(){
	testUtil.ExplicitWait();
	Assert.assertTrue(homePage.verifyLoginLogo());
}

@Test(priority=5)
public void verifyContactUsLogoTest(){
	testUtil.ExplicitWait();
	Assert.assertTrue(homePage.verifyContactUsLogo());
}

@Test(priority=6)
public void verifyAboutUsLogoTest(){
	testUtil.ExplicitWait();
	Assert.assertTrue(homePage.verifyAboutUsLogo());
}

@Test(priority=7)
public void verifySignupButtonTest(){
	testUtil.ExplicitWait();
	signUpPage = homePage.clickOnSignUpLogo();
}


	@AfterMethod
		public void tearDown(){
		driver.quit();
		}
		
		
		
		

}
