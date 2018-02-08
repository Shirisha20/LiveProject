package com.JusDone.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.JusDone.qa.Base.TestBase;

public class DashBoardPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "html/body/div[1]/nav/div[1]/a[1]/img")
	WebElement JusDoneImage;

	@FindBy(xpath = "//div[@class='user-info']")
	WebElement UserName;

	@FindBy(xpath = "//span[contains(text(),'Dashboard')]")
	WebElement DashBoardBtn;

	@FindBy(xpath = "/html/body/div/div[1]/div/nav/ul/li[2]/a/span")
	WebElement TaskBtn;

	@FindBy(xpath = "//span[contains(text(),'Teams')]")
	WebElement TeamsBtn;

	@FindBy(xpath = "//span[contains(text(),'Invites')]")
	WebElement InvitesBtn;

	@FindBy(xpath = "//*[contains(text(),'Settings')]")
	WebElement SettingsBtn;

	@FindBy(xpath = "//button[@type='button']")
	WebElement MenuBar;

	@FindBy(xpath = "//input[@type='text']")
	WebElement SearchBox;

	@FindBy(xpath = "//h4[@class='text-primary']")
	WebElement TeamsLabel;

	@FindBy(xpath = "/html/body/div/div[1]/div/div/div[1]/div/div[1]/div/div/div/div/center/ul/li[2]/a")
	WebElement CreateNewTeamBtn;

	@FindBy(xpath = "//i[@class='fa fa-bell']")
	WebElement BellBtn;

	@FindBy(xpath = "/html/body/div/nav/div[2]/ul/li[2]/a")
	WebElement LogOutBtn;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement AddBtn;

	@FindBy(xpath = "//input[@id='team-name']")
	WebElement TeamNameBox;

	@FindBy(xpath = "//input[@id='team_size']")
	WebElement TeamSizeBox;

	@FindBy(xpath = "//input[@id='company_name']")
	WebElement CompanyNameField;

	@FindBy(xpath = "//input[@id='company_url']")
	WebElement CompanyURLField;

	@FindBy(xpath = "/html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div[1]/h5")
	WebElement TeamNameLabel;

	@FindBy(xpath = "html/body/div[1]/div[1]/div/div/div[1]/div/div[2]/div[1]/div/div/div/div/center/ul/li[2]/a")
	WebElement CreateNewTaskLink;

	// Initializing the Page Objects:
	public DashBoardPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying JusDone Image is Displayed
	public boolean verifyJusDoneImage() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return JusDoneImage.isDisplayed();
	}

	// Verifying Name(Shirisha) is Displayed
	public boolean verifyUserName() {
		return UserName.isDisplayed();
	}

	// Verifying Teams Label is Displayed
	public boolean verifyTeamLabel() {
		return TeamsLabel.isDisplayed();
	}

	// Verifying Search Box is Displayed
	public boolean verifySearchBox() {
		return SearchBox.isDisplayed();
	}

	// Verifying TeamName Label is Displayed
	public boolean verifyTeamNameLabel() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", TeamNameLabel);
		return TeamNameLabel.isDisplayed();
	}

	// Verifying DashBoard Button is Enabled
	public boolean verifyDashBoardBtn() {
		return DashBoardBtn.isEnabled();
	}

	// Verifying Teams Button is Enabled
	public boolean verifyTeamsBtn() {
		return TeamsBtn.isEnabled();
	}

	// Verifying Task Button is Enabled
	public boolean verifyTaskBtn() {
		return TaskBtn.isEnabled();
	}

	// Verifying Invites Button is Enabled
	public boolean verifyInvitesBtn() {
		return InvitesBtn.isEnabled();
	}

	// Verifying Settings Button is Enabled
	public boolean verifySettingsBtn() {
		return SettingsBtn.isEnabled();
	}

	// Verifying MenuBar is Enabled
	public boolean verifyMenuBar() {
		return MenuBar.isEnabled();
	}

	// Verifying CreateNewTeam Button is Enabled
	public boolean verifyCreateNewTeamBtn() {
		return CreateNewTeamBtn.isEnabled();
	}

	// Verifying Bell Button is Enabled
	public boolean verifyBellBtn() {
		return BellBtn.isEnabled();
	}

	// Verifying CreateNewTaskLink is Enabled
	public boolean verifyCreateNewTaskLink() {
		return CreateNewTaskLink.isEnabled();
	}

	// Verifying LogOut Button is Enabled
	public boolean verifyLogOutBtn() {
		return LogOutBtn.isEnabled();
	}

	// Clicking CreateTeam Button
	public void ClickCreateTeamBtn() {
		try {
			Thread.sleep(5000);
			CreateNewTeamBtn.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	// Clicking CreateNewTask Link
	public void ClickCreateNewTaskLink() {
		CreateNewTaskLink.click();
	}

	// Creating Team
	public void CreateTeam(String TeamName, String TeamSize, String CompanyName, String CompanyURL) {
		TeamNameBox.sendKeys(TeamName);
		TeamSizeBox.sendKeys(TeamSize);
		CompanyNameField.sendKeys(CompanyName);
		CompanyURLField.sendKeys(CompanyURL);
		AddBtn.click();
	}

	public TaskPage ClickTaskBtn() {
		try {
			Thread.sleep(5000);
			TaskBtn.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new TaskPage();
	}

	// Clicking LogOut button
	public void ClickLogOutBtn() {
		LogOutBtn.click();
	}

}
