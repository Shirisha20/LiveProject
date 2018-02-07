package com.JusDone.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.JusDone.qa.Base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "html/body/div[1]/div/div/div/h3")
	WebElement LoginName;

	@FindBy(xpath = "html/body/div[1]/div/div/div/form/div[3]/div/label")
	WebElement RememberMe;

	@FindBy(xpath = "//*[@id=\"email\"]")
	WebElement UserName;

	@FindBy(xpath = "//*[@id=\"password\"]")
	WebElement Password;

	@FindBy(xpath = "html/body/div[1]/div/div/div/form/div[3]/a")
	WebElement ForgotPwd;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/form/div[4]/button")
	WebElement LoginBtn;

	@FindBy(xpath = "html/body/div[1]/div/div/div/form/a")
	WebElement CreateAcctBtn;

	@FindBy(xpath = "html/body/div[1]/div/div/div/form/div[1]/span/strong")
	WebElement ErrorMsg;

	@FindBy(xpath = "/html/body/div/div[1]/div/nav/div/p[1]")
	WebElement CorrectAcctName;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying LoginName is Displayed
	public boolean verifyLoginName() {
		return LoginName.isDisplayed();
	}

	// Verifying ForgotPwd is Displayed
	public boolean verifyLForgotPwd() {
		return ForgotPwd.isEnabled();
	}

	// Verifying LoginBtn is Enabled
	public boolean verifyLoginBtn() {
		return LoginBtn.isEnabled();
	}

	// Verifying RememberMe is Selected
	public boolean verifyLRememberMe() {
		return RememberMe.isSelected();
	}

	// Verifying CreateAcctBtn is Enabled
	public boolean verifyLCreateAcctBtn() {
		return CreateAcctBtn.isEnabled();
	}

	// Entering Registered Account Values
	public DashBoardPage ValidLogin(String EmailId, String Pwd) {
		UserName.sendKeys(EmailId);
		// UserName.sendKeys(Keys.ENTER);
		Password.sendKeys(Pwd);
		// Password.sendKeys(Keys.ENTER);
		try {
			Thread.sleep(3000);
			LoginBtn.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		JavascriptExecutor jErrorMsg = (JavascriptExecutor) driver;
		jErrorMsg.executeScript("arguments[0].click();", CorrectAcctName);
		String Actual = CorrectAcctName.getText();
		Assert.assertEquals(Actual, "Shirisha");

		return new DashBoardPage();
	}

	// Entering Invalid Values
	public LoginPage InvalidLogin(String EmailId, String Pwd) {
		UserName.sendKeys(EmailId);
		UserName.sendKeys(Keys.ENTER);
		Password.sendKeys(Pwd);
		Password.sendKeys(Keys.ENTER);
		LoginBtn.click();

		JavascriptExecutor jErrorMsg = (JavascriptExecutor) driver;
		jErrorMsg.executeScript("arguments[0].click();", ErrorMsg);
		String Actual = ErrorMsg.getText();
		Assert.assertEquals(Actual, "These credentials do not match our records.");
		return new LoginPage();
	}

	// Leaving UserName field Blank
	public LoginPage BlankInputLogin(String EmailId, String Pwd) {
		UserName.sendKeys(EmailId);
		UserName.sendKeys(Keys.ENTER);
		Password.sendKeys(Pwd);
		Password.sendKeys(Keys.ENTER);
		LoginBtn.click();

		List<WebElement> Elements = driver.findElements(By.tagName("input"));
		Boolean ElementExists = false;
		for (int counter = 0; counter < Elements.size(); counter++) {
			if (Elements.get(counter).getText().equals("Please fill out this field.")) {
				ElementExists = true;
			}
		}
		return new LoginPage();
	}

	// Clicking the Login Button
	public DashBoardPage ClickLoginButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", LoginBtn);
		LoginBtn.click();
		return new DashBoardPage();
	}

}
