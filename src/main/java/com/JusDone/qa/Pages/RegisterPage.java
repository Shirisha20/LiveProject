package com.JusDone.qa.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.JusDone.qa.Base.TestBase;
import com.JusDone.qa.Util.TestUtil;

public class RegisterPage extends TestBase {
	static TestUtil testUtil;

	// Page Factory - OR:
	@FindBy(xpath = "html/body/div[1]/div/div/div/h3")
	WebElement RegisterName;

	@FindBy(xpath = "/html/body/div[1]/div/div/div/form/p/a")
	WebElement SignInBtn;

	@FindBy(xpath = "//*[@id='name']")
	WebElement UserName;

	@FindBy(xpath = "//*[@id='email']")
	WebElement EmailAddress;

	@FindBy(xpath = "//*[@id='password']")
	WebElement Password;

	@FindBy(xpath = "//*[@id='password-confirm']")
	WebElement ConfirmPassword;

	@FindBy(xpath = "//button[@type='submit']")
	WebElement RegisterBtn;

	@FindBy(xpath = "/html/body/div/div[1]/div/nav/div/p[1]")
	WebElement CorrectAcctName;

	@FindBy(xpath = "//span[@class='help-block']/strong")
	WebElement ExistingAcctError;

	@FindBy(xpath = "html/body/div[1]/div/div/div/form/div[2]/span/strong")
	WebElement InvalidEmailError;

	@FindBy(xpath = "html/body/div[1]/div/div/div/form/div[3]/span")
	WebElement PwdMatchError;

	@FindBy(xpath = "//input[@name='_token']")
	WebElement BlankFieldError;

	// Initializing the Page Objects:
	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Display of RegisterName
	public boolean verifyRegisterName() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", RegisterName);
		return RegisterName.isDisplayed();
	}

	// Verifying Enable of SignIn Button
	public boolean verifySignInBtn() {
		/*
		 * JavascriptExecutor js = (JavascriptExecutor) driver;
		 * js.executeScript("arguments[0].click();", SignInBtn);
		 */
		return SignInBtn.isEnabled();
	}

	// Clicking on Register Button and Returning to TeamsPage
	public DashBoardPage ClickRegisterButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", RegisterBtn);
		RegisterBtn.click();
		return new DashBoardPage();
	}

	// Verifying AcctName Messege Text ( "abcd")
	public DashBoardPage VerifyValidAcctNameMsg(String Name, String Email, String Pwd, String ConfirmPwd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", UserName);
		UserName.sendKeys(Name);

		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript("arguments[0].click();", EmailAddress);
		EmailAddress.sendKeys(Email);

		JavascriptExecutor jsP = (JavascriptExecutor) driver;
		jsP.executeScript("arguments[0].click();", Password);
		Password.sendKeys(Pwd);

		JavascriptExecutor jsCp = (JavascriptExecutor) driver;
		jsCp.executeScript("arguments[0].click();", ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPwd);
		RegisterBtn.click();

		JavascriptExecutor jInvalidEmailError = (JavascriptExecutor) driver;
		jInvalidEmailError.executeScript("arguments[0].click();", CorrectAcctName);
		try {
			String Actual = CorrectAcctName.getText();
			Thread.sleep(2000);
			Assert.assertEquals(Actual, "sv7");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		return new DashBoardPage();
	}

	// Verifying ExistingAcctError Messege ("The email has already been taken.")
	public RegisterPage VerifyExistingAcctErrorMsg(String Name, String Email, String Pwd, String ConfirmPwd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", UserName);
		UserName.sendKeys(Name);

		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript("arguments[0].click();", EmailAddress);
		EmailAddress.sendKeys(Email);

		JavascriptExecutor jsP = (JavascriptExecutor) driver;
		jsP.executeScript("arguments[0].click();", Password);
		Password.sendKeys(Pwd);

		JavascriptExecutor jsCp = (JavascriptExecutor) driver;
		jsCp.executeScript("arguments[0].click();", ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPwd);
		RegisterBtn.click();

		JavascriptExecutor jExistingAcctError = (JavascriptExecutor) driver;
		jExistingAcctError.executeScript("arguments[0].click();", ExistingAcctError);
		String Actual = ExistingAcctError.getText();
		Assert.assertEquals(Actual, "The email has already been taken.");
		return new RegisterPage();
	}

	// Verifying InvalidEmailError Messege( "The email must be a valid email
	// address.")
	public RegisterPage VerifyInvalidEmailErrorMsg(String Name, String Email, String Pwd, String ConfirmPwd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", UserName);
		UserName.sendKeys(Name);

		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript("arguments[0].click();", EmailAddress);
		EmailAddress.sendKeys(Email);

		JavascriptExecutor jsP = (JavascriptExecutor) driver;
		jsP.executeScript("arguments[0].click();", Password);
		Password.sendKeys(Pwd);

		JavascriptExecutor jsCp = (JavascriptExecutor) driver;
		jsCp.executeScript("arguments[0].click();", ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPwd);
		RegisterBtn.click();

		JavascriptExecutor jInvalidEmailError = (JavascriptExecutor) driver;
		jInvalidEmailError.executeScript("arguments[0].click();", InvalidEmailError);
		String Actual = InvalidEmailError.getText();
		Assert.assertEquals(Actual, "The email must be a valid email address.");
		return new RegisterPage();
	}

	// Verifying PasswordMatchError Messege ( "The password confirmation does not
	// match.")
	public RegisterPage VerifyPwdMatchErrorMsg(String Name, String Email, String Pwd, String ConfirmPwd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", UserName);
		UserName.sendKeys(Name);

		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript("arguments[0].click();", EmailAddress);
		EmailAddress.sendKeys(Email);

		JavascriptExecutor jsP = (JavascriptExecutor) driver;
		jsP.executeScript("arguments[0].click();", Password);
		Password.sendKeys(Pwd);

		JavascriptExecutor jsCp = (JavascriptExecutor) driver;
		jsCp.executeScript("arguments[0].click();", ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPwd);
		RegisterBtn.click();

		JavascriptExecutor jsPwdError = (JavascriptExecutor) driver;
		jsPwdError.executeScript("arguments[0].click();", PwdMatchError);
		String Actual = PwdMatchError.getText();
		Assert.assertEquals(Actual, "The password confirmation does not match.");
		return new RegisterPage();
	}

	// Verifying BlankError Messege ( "Please fill out this field.")
	public RegisterPage VerifyBlankErrorMsg(String Name, String Email, String Pwd, String ConfirmPwd) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", UserName);
		UserName.sendKeys(Name);

		JavascriptExecutor jsE = (JavascriptExecutor) driver;
		jsE.executeScript("arguments[0].click();", EmailAddress);
		EmailAddress.sendKeys(Email);

		JavascriptExecutor jsP = (JavascriptExecutor) driver;
		jsP.executeScript("arguments[0].click();", Password);
		Password.sendKeys(Pwd);

		JavascriptExecutor jsCp = (JavascriptExecutor) driver;
		jsCp.executeScript("arguments[0].click();", ConfirmPassword);
		ConfirmPassword.sendKeys(ConfirmPwd);
		RegisterBtn.click();

		List<WebElement> Elements = driver.findElements(By.tagName("input"));
		Boolean ElementExists = false;
		for (int counter = 0; counter < Elements.size(); counter++) {
			if (Elements.get(counter).getText().equals("Please fill out this field.")) {
				ElementExists = true;
			}
		}
		return new RegisterPage();
	}

	// Clicking on SignIn Button and Returning to LoginPage
	public LoginPage ClickSignInButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", SignInBtn);
		return new LoginPage();
	}

}
