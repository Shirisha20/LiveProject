package com.JusDone.qa.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.JusDone.qa.Base.TestBase;

public class AcctPage extends TestBase {
	
	//Page Factory - OR:
		@FindBy(xpath ="html/body/div[1]/button[2]")
		WebElement NameWithLogo;
		
		@FindBy(xpath ="html/body/div[1]/button[1]")
		WebElement JusDoneLogo;
		
		// Initializing the Page Objects:
		public  AcctPage() {
			PageFactory.initElements(driver, this);
		}
		
		public boolean verifyNameWithLogo(){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", NameWithLogo);
			return NameWithLogo.isDisplayed();
		}
		
		public boolean verifyJusDoneLogo(){
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", JusDoneLogo);
			return JusDoneLogo.isDisplayed();
		}
		
		public String VerifyText() {
			return NameWithLogo.getText();
		}
		
		public ErrorPage ClickNameWithLogoButton() {
			JavascriptExecutor js = (JavascriptExecutor)driver;
			 js.executeScript("arguments[0].click();", NameWithLogo);
			NameWithLogo.click();
			return new ErrorPage();
		}
		
	

}
