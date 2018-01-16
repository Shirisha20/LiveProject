package com.JusDone.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.JusDone.qa.Base.TestBase;

public class ErrorPage extends TestBase {
	
	//Page Factory - OR:
			@FindBy(xpath ="/html/body/div/div/form/div[2]/div/span/strong")
			WebElement ErrorMsg;
			
			@FindBy(xpath ="html/body/div[1]/button[1]")
			WebElement JDButton;
			
		
			
			
			// Initializing the Page Objects:
			public  ErrorPage() {
				PageFactory.initElements(driver, this);
			}
			
			public String VerifyErrorMsg() {
				JavascriptExecutor js = (JavascriptExecutor)driver;
				 js.executeScript("arguments[0].click();", ErrorMsg);
				return ErrorMsg.getText();
			}
			
			public HomePage ClickJDButton() {
				JDButton.click();
				return new HomePage();
			}
			
			
}
