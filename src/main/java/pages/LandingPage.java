package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends PageBase {

	public LandingPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		Driver = driver;
	}
	JavascriptExecutor js;	
	WebDriver Driver;
	 
	//get the English language button element 
	@FindBy(css = ".lang-list ul li")
	WebElement EnglishLanguage;
	
	public void selectingWebsiteLanguage()
	{
		// click on the english language button
		ClickButton(EnglishLanguage);
	}
}
