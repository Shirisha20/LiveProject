package com.JusDone.qa.TestCases;

import org.testng.Assert;
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
		extentTest = extentReports.startTest("verifyJusDoneImageTest");
		Assert.assertTrue(dashBoardPage.verifyJusDoneImage());
	}

	// Verifying Name(Shirisha) is Displayed
	@Test(priority = 2)
	public void verifyUserNameTest() {

		extentTest = extentReports.startTest("verifyUserNameTest");
		Assert.assertTrue(dashBoardPage.verifyUserName());
	}

	// Verifying Teams Label is Displayed
	@Test(priority = 3)
	public void verifyTeamLabelTest() {

		extentTest = extentReports.startTest("verifyTeamLabelTest");
		Assert.assertTrue(dashBoardPage.verifyTeamLabel());
	}

	// Verifying Search Box is Displayed
	@Test(priority = 4)
	public void verifySearchBoxTest() {

		extentTest = extentReports.startTest("verifySearchBoxTest");
		Assert.assertTrue(dashBoardPage.verifySearchBox());
	}

	// Verifying TeamName Label is Displayed
	@Test(priority = 5)
	public void verifyTeamNameLabelTest() {

		extentTest = extentReports.startTest("verifyTeamNameLabelTest");
		Assert.assertTrue(dashBoardPage.verifyTeamNameLabel());
	}

	// Verifying DashBoard Button is Enabled
	@Test(priority = 6)
	public void verifyDashBoardBtnTest() {

		extentTest = extentReports.startTest("verifyDashBoardBtnTest");
		Assert.assertTrue(dashBoardPage.verifyDashBoardBtn());
	}

	// Verifying Teams Button is Enabled
	@Test(priority = 7)
	public void verifyTeamsBtnTest() {

		extentTest = extentReports.startTest("verifyTeamsBtnTest");
		Assert.assertTrue(dashBoardPage.verifyTeamsBtn());
	}

	// Verifying Task Button is Enabled
	@Test(priority = 8)
	public void verifyTaskBtnTest() {

		extentTest = extentReports.startTest("verifyTaskBtnTest");
		Assert.assertTrue(dashBoardPage.verifyTaskBtn());
	}

	// Verifying Invites Button is Enabled
	@Test(priority = 9)
	public void verifyInvitesBtnTest() {

		extentTest = extentReports.startTest("verifyInvitesBtnTest");
		Assert.assertTrue(dashBoardPage.verifyInvitesBtn());
	}

	// Verifying Settings Button is Enabled
	@Test(priority = 10)
	public void verifySettingsBtnTest() {

		extentTest = extentReports.startTest("verifySettingsBtnTest");
		Assert.assertTrue(dashBoardPage.verifySettingsBtn());
	}

	// Verifying MenuBar is Enabled
	@Test(priority = 11)
	public void verifyMenuBarTest() {

		extentTest = extentReports.startTest("verifyMenuBarTest");
		Assert.assertTrue(dashBoardPage.verifyMenuBar());
	}

	// Verifying CreateNewTeam Button is Enabled
	@Test(priority = 12)
	public void verifyCreateNewTeamBtnTest() {

		extentTest = extentReports.startTest("verifyCreateNewTeamBtnTest");
		Assert.assertTrue(dashBoardPage.verifyCreateNewTeamBtn());
	}

	// Verifying Bell Button is Enabled
	@Test(priority = 13)
	public void verifyBellBtnTest() {

		extentTest = extentReports.startTest("verifyBellBtnTest");
		Assert.assertTrue(dashBoardPage.verifyBellBtn());
	}

	// Verifying LogOut Button is Enabled
	@Test(priority = 14)
	public void verifyLogOutBtnTest() {

		extentTest = extentReports.startTest("verifyLogOutBtnTest");
		Assert.assertTrue(dashBoardPage.verifyLogOutBtn());
	}

	// Verifying CreateNewTaskLink is Enabled
	@Test(priority = 15)
	public void verifyCreateNewTaskLinkTest() {

		extentTest = extentReports.startTest("verifyCreateNewTaskLinkTest");
		Assert.assertTrue(dashBoardPage.verifyCreateNewTaskLink());
	}

	// Clicking on CreateNewTeam Button and Creating New Team
	@Test(priority = 16)
	public void CreateTeamBtnTest() {

		extentTest = extentReports.startTest("CreateTeamBtnTest");
		dashBoardPage.ClickCreateTeamBtn();
		dashBoardPage.CreateTeam("TechSpririt", "8", "Varkasa", "varakasa.com");
	}

	// Clicking on Task Button to go to Task Page
	@Test(priority = 17, enabled = true)
	public void ClickCreateNewTaskLinkTest() {

		extentTest = extentReports.startTest("ClickCreateNewTaskLinkTest");
		dashBoardPage.ClickCreateNewTaskLink();
	}

	// Clicking CreateNewTask Link
	@Test(priority = 18)
	public void ClickTaskBtnTest() {

		extentTest = extentReports.startTest("ClickTaskBtnTest");
		taskPage = dashBoardPage.ClickTaskBtn();
	}

	// Clicking LogOut button
	@Test(priority = 19)
	public void ClickLogOutBtn() {

		extentTest = extentReports.startTest("ClickLogOutBtn");
		dashBoardPage.ClickLogOutBtn();
	}

}
