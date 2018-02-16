package com.JusDone.qa.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.JusDone.qa.Base.TestBase;

public class HomePage extends TestBase {

	// Page Factory - OR:
	@FindBy(xpath = "html/body/div[1]/div/button")
	WebElement JusDoneLogo;

	@FindBy(xpath = "//label[@for='c3']")
	WebElement SignUpLogo;

	@FindBy(xpath = "//label[@for='c1']")
	WebElement LoginLogo;

	@FindBy(xpath = "//label[@for='c7']")
	WebElement AboutUsLogo;

	@FindBy(xpath = "//label[@for='c5']")
	WebElement ContactUsLogo;

	@FindBy(xpath = "/html/body/div/div/ul/li[1]/label")
	WebElement LoginButton;

	// Initializing the Page Objects:
	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	// Verifying Title of the JusDone Application
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}

	// Verifying JusDone Logo is Displayed
	public boolean verifyJusDoneLogo() {
		return JusDoneLogo.isDisplayed();
	}

	// Verifying SignUp Logo is Displayed
	public boolean verifySignUpLogo() {
		return SignUpLogo.isDisplayed();
	}

	// Verifying Login Logo is Displayed
	public boolean verifyLoginLogo() {
		return LoginLogo.isDisplayed();
	}

	// Verifying AboutUs Logo is Displayed
	public boolean verifyAboutUsLogo() {
		return AboutUsLogo.isDisplayed();
	}

	// Verifying ContactUs Logo is Displayed
	public boolean verifyContactUsLogo() {
		return ContactUsLogo.isDisplayed();
	}

	// Clicking on SignUp Logo
	public RegisterPage clickOnSignUpLogo() {
		SignUpLogo.click();
		return new RegisterPage();
	}

	// Clicking on Login Logo
	public LoginPage ClickLoginBtn() {
		try {
			Thread.sleep(3000);
			LoginButton.click();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return new LoginPage();

	}

}
