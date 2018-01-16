package com.JusDone.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.JusDone.qa.Base.TestBase;


public class HomePage extends TestBase {
	
	//Page Factory - OR:
		@FindBy(xpath ="html/body/div[1]/div/button")
		WebElement JusDoneLogo;
		
		@FindBy(xpath="//label[@for='c3']")
		WebElement SignUpLogo;
		
		@FindBy(xpath = "//label[@for='c1']")
		WebElement LoginLogo;

		@FindBy(xpath = "//label[@for='c7']")
		WebElement AboutUsLogo;
		
		@FindBy(xpath = "//label[@for='c5']")
		WebElement ContactUsLogo;
		
		@FindBy(xpath ="html/body/div[1]/div/ul/li[1]/label")
		WebElement LoginButton;
		
		// Initializing the Page Objects:
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		public String verifyHomePageTitle(){
				return driver.getTitle();
		}
		
		public boolean verifyJusDoneLogo(){
			return JusDoneLogo.isDisplayed();
		}
		
		public boolean verifySignUpLogo(){
			return SignUpLogo.isDisplayed();
		}
		
		public boolean verifyLoginLogo(){
			return LoginLogo.isDisplayed();
		}
		
		public boolean verifyAboutUsLogo(){
			return AboutUsLogo.isDisplayed();
		}
		
		public boolean verifyContactUsLogo(){
			return ContactUsLogo.isDisplayed();
		}
		
		public SignUpPage clickOnSignUpLogo(){
		SignUpLogo.click();
		return new SignUpPage();
		}
		
		public LoginPage ClickLoginBtn() {

			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", LoginButton);
			LoginButton.click();
			return new LoginPage();
			
		}





}
