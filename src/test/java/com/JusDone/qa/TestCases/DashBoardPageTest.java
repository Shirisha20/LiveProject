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

public class DashBoardPageTest extends TestBase {

	HomePage homePage;
	RegisterPage registerPage;
	LoginPage loginPage;
	DashBoardPage dashBoardPage;
	TaskPage taskPage;
	TestUtil testUtil;

	public DashBoardPageTest() {
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

	}

	// Verifying JusDone Image is Displayed
	@Test(priority = 1)
	public void verifyJusDoneImageTest() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Assert.assertTrue(dashBoardPage.verifyJusDoneImage());
	}

	// Verifying Name(Shirisha) is Displayed
	@Test(priority = 2)
	public void verifyUserNameTest() {
		Assert.assertTrue(dashBoardPage.verifyUserName());
	}

	// Verifying Teams Label is Displayed
	@Test(priority = 3)
	public void verifyTeamLabelTest() {
		Assert.assertTrue(dashBoardPage.verifyTeamLabel());
	}

	// Verifying Search Box is Displayed
	@Test(priority = 4)
	public void verifySearchBoxTest() {
		Assert.assertTrue(dashBoardPage.verifySearchBox());
	}

	// Verifying TeamName Label is Displayed
	@Test(priority = 5)
	public void verifyTeamNameLabelTest() {
		Assert.assertTrue(dashBoardPage.verifyTeamNameLabel());
	}

	// Verifying DashBoard Button is Enabled
	@Test(priority = 6)
	public void verifyDashBoardBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyDashBoardBtn());
	}

	// Verifying Teams Button is Enabled
	@Test(priority = 7)
	public void verifyTeamsBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyTeamsBtn());
	}

	// Verifying Task Button is Enabled
	@Test(priority = 8)
	public void verifyTaskBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyTaskBtn());
	}

	// Verifying Invites Button is Enabled
	@Test(priority = 9)
	public void verifyInvitesBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyInvitesBtn());
	}

	// Verifying Settings Button is Enabled
	@Test(priority = 10)
	public void verifySettingsBtnTest() {
		Assert.assertTrue(dashBoardPage.verifySettingsBtn());
	}

	// Verifying MenuBar is Enabled
	@Test(priority = 11)
	public void verifyMenuBarTest() {
		Assert.assertTrue(dashBoardPage.verifyMenuBar());
	}

	// Verifying CreateNewTeam Button is Enabled
	@Test(priority = 12)
	public void verifyCreateNewTeamBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyCreateNewTeamBtn());
	}

	// Verifying Bell Button is Enabled
	@Test(priority = 13)
	public void verifyBellBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyBellBtn());
	}

	// Verifying LogOut Button is Enabled
	@Test(priority = 14)
	public void verifyLogOutBtnTest() {
		Assert.assertTrue(dashBoardPage.verifyLogOutBtn());
	}

	// Verifying CreateNewTaskLink is Enabled
	@Test(priority = 15)
	public void verifyCreateNewTaskLinkTest() {
		Assert.assertTrue(dashBoardPage.verifyCreateNewTaskLink());
	}

	// Clicking on CreateNewTeam Button and Creating New Team
	@Test(priority = 16)
	public void CreateTeamBtnTest() {
		dashBoardPage.ClickCreateTeamBtn();
		dashBoardPage.CreateTeam("TechSpririt", "8", "Varkasa", "varakasa.com");
	}

	// Clicking on Task Button to go to Task Page
	@Test(priority = 17)
	public void ClickCreateNewTaskLinkTest() {
		dashBoardPage.ClickCreateNewTaskLink();
	}

	// Clicking CreateNewTask Link
	@Test(priority = 18)
	public void ClickTaskBtnTest() {
		taskPage = dashBoardPage.ClickTaskBtn();
	}

	// Clicking LogOut button
	@Test(priority = 19)
	public void ClickLogOutBtn() {
		dashBoardPage.ClickLogOutBtn();
	}

	// Closing the Browser
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
