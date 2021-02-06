package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LandingPage;

public class SelectingLanguageTest extends TestBase {

	LandingPage landingPageObject;
	
	// selecting the english language then verify that the English language selected correctly
	@Test
	public void SelectWebsiteLanguage()
	{
		landingPageObject = new LandingPage(driver);
		landingPageObject.selectingWebsiteLanguage();
		Assert.assertTrue(driver.getCurrentUrl().contains("en/"));
	}
}
