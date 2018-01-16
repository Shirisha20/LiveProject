package com.JusDone.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.JusDone.qa.Base.TestBase;

public class SignUpPage extends TestBase{
	
	//Page Factory - OR:
			@FindBy(xpath ="html/body/div[1]/button[2]")
			WebElement SignUpPageLogo;
			
			@FindBy(xpath = "//button[contains(@class, 'target')]")
			WebElement SignUpJusDoneLogo;
			
			// Initializing the Page Objects:
			public  SignUpPage() {
				PageFactory.initElements(driver, this);
			}
			
			public boolean verifySignUpJusDoneLogo(){
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", SignUpJusDoneLogo);
				return SignUpJusDoneLogo.isDisplayed();
			}
			
			public boolean verifySignUpPageLogo(){
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", SignUpPageLogo);
				return SignUpPageLogo.isDisplayed();
			}
			
			public RegistrationFormPage clickOnSignUpPageLogo(){
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", SignUpPageLogo);
				//SignUpPageLogo.click();
				return new RegistrationFormPage();
				}
			

}
