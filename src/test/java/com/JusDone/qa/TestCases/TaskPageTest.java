package com.JusDone.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Pages.DashBoardPage;
import com.JusDone.qa.Pages.HomePage;
import com.JusDone.qa.Pages.LoginPage;
import com.JusDone.qa.Pages.RegisterPage;
import com.JusDone.qa.Pages.TaskPage;
import com.JusDone.qa.Util.TestUtil;

public class TaskPageTest extends TestBase {

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TaskPage taskPage;
	TestUtil testUtil;

	public TaskPageTest() {
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
		dashBoardPage = new DashBoardPage();
		taskPage = new TaskPage();
		homePage.ClickLoginBtn();
		loginPage.ValidLogin(prop.getProperty("EmailId"), prop.getProperty("Pwd"));
		dashBoardPage.ClickTaskBtn();
	}

	// Verifying CreateNewTask Link is Displayed
	@Test(priority = 1)
	public void verifyCreateNewTaskLinkTest() {
		Assert.assertTrue(taskPage.verifyCreateNewTaskLink());
	}

	// Verifying Members link is Displayed
	@Test(priority = 2)
	public void verifyMembersLinkTest() {
		Assert.assertTrue(taskPage.verifyMembersLink());
	}

	// Verifying Settings link is Displayed
	@Test(priority = 3)
	public void verifySettingsLinkTest() {
		Assert.assertTrue(taskPage.verifySettingsLink());
	}

	// Clicking on CreateTaskButton
	@Test(priority = 4)
	public void ClickCreateNewTaskLinkTest() {
		taskPage.ClickCreateNewTaskLink();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
