package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LandingPage;
import tests.TestBase;

public class SelectingLanguage extends TestBase{

	//WebDriver Driver;
	LandingPage landingPageObject;

	@When(": Click on the English Language button")
	public void click_on_the_english_language_button() 
	{
		landingPageObject = new LandingPage(driver);
		landingPageObject.selectingWebsiteLanguage();
	}

	@Then(": The user will be redirected to the home page with the english language")
	public void User_Redirected_to_HomePage_EnglishLanguage()
	{
		Assert.assertTrue(driver.getCurrentUrl().contains("en/"));
	}
}
