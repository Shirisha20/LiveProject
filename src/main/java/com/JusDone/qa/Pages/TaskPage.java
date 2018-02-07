package com.JusDone.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.JusDone.qa.Base.TestBase;

public class TaskPage extends TestBase {

	//Page Factory - OR:
	@FindBy(xpath = "//*[@id='home']/div/div/div/div/center/a")
	WebElement CreateNewTaskLink;
	
	@FindBy(xpath = "html/body/div[1]/div[1]/div/div/div/div/div[2]/div/ul/li[2]/a")
		WebElement MembersLink;
		
	@FindBy(xpath = "html/body/div[1]/div[1]/div/div/div/div/div[2]/div/ul/li[3]/a")
		WebElement SettingsLink;


	// Initializing the Page Objects:
	public TaskPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying CreateNewTask Link is Displayed
	public boolean verifyCreateNewTaskLink(){
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CreateNewTaskLink.isDisplayed();
	}

	// Verifying Members link is Displayed
	public boolean verifyMembersLink(){
		return MembersLink.isDisplayed();
	}
	
	// Verifying Settings link is Displayed
		public boolean verifySettingsLink(){
			return SettingsLink.isDisplayed();
		}
	// Clicking on CreateTaskButton
	public void ClickCreateNewTaskLink() {
		try {
			Thread.sleep(3000);
			CreateNewTaskLink.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
}
	/*// Creating  Task
		public void CreateTask() {
			TaskNameField.click();
			TaskNameField.sendKeys("Working On JusDone Manual Test Cases");
			Select drpAssignTo = new Select(driver.findElement(By.xpath("//*[@id='assign']")));
			 drpAssignTo.selectByVisibleText("Shirisha");
			 AddTaskBtn.click();
		}	*/


