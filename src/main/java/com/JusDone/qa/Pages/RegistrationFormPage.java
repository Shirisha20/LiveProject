package com.JusDone.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.JusDone.qa.Base.TestBase;

public class RegistrationFormPage extends TestBase {
	
	//Page Factory - OR:
	@FindBy(xpath =" //button[contains(@class, 'jdButton')]")
	WebElement registerFormJDPageLogo;
	
	@FindBy(xpath = "html/body/div/button[2]")
	WebElement registerFormSignUpLogo;
	
	@FindBy(xpath = "//*[@id='name']")
	WebElement NameField;
	
	@FindBy(xpath = "//*[@id='email']")
	WebElement EmailField;
	
	@FindBy(xpath = "//*[@id='password']")
	WebElement PwdField;
	
	@FindBy(xpath = "//*[@id='password-confirm']")
	WebElement ConfirmPwdField;

	@FindBy(xpath="//*[@id='register']/button")
	WebElement RegisterButton;
	
	
	// Initializing the Page Objects:
				public  RegistrationFormPage() {
					PageFactory.initElements(driver, this);
				}
				
				public boolean verifyRegisterFormSignUpLogo(){
					JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", registerFormSignUpLogo);
					return registerFormSignUpLogo.isDisplayed();
				}
				
				public boolean verifyRegisterFormJDPageLogo(){
					JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", registerFormJDPageLogo);
					return registerFormJDPageLogo.isDisplayed();
				}
				
				public void ValidCreateNewAcct(String Name,  String Email, String Pwd, String ConfirmPwd) {
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", NameField);
					NameField.sendKeys(Name);
					NameField.sendKeys(Keys.ENTER);
					
					JavascriptExecutor jsE = (JavascriptExecutor)driver;
					 jsE.executeScript("arguments[0].click();", EmailField);
					EmailField.sendKeys(Email);
					EmailField.sendKeys(Keys.ENTER);
					
					JavascriptExecutor jsP = (JavascriptExecutor)driver;
					 jsP.executeScript("arguments[0].click();", PwdField);
					PwdField.sendKeys(Pwd);
					PwdField.sendKeys(Keys.ENTER);
					
					JavascriptExecutor jsCp = (JavascriptExecutor)driver;
					 jsCp.executeScript("arguments[0].click();", ConfirmPwdField);
					ConfirmPwdField.sendKeys(ConfirmPwd);
					ConfirmPwdField.sendKeys(Keys.ENTER);
				}
				
				public AcctPage ClickRegisterButton() {
					JavascriptExecutor js = (JavascriptExecutor)driver;
					 js.executeScript("arguments[0].click();", RegisterButton);
					RegisterButton.click();
					return new AcctPage();
					
				}
}
