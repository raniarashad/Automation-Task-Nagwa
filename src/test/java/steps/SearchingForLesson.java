package steps;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.SearchingObject;
import tests.TestBase;

public class SearchingForLesson extends TestBase {

	SearchingObject Object;
	
	@When(": search for specific keyword and verify the result")
	public void search_for_specific_keyword_and_verify_the_result() throws IOException {
		
		Object = new SearchingObject(driver);
		Object.SearchingFunction();
	}
	
	@Then(": User will click on the second lesson")
	public void User_will_click_on_the_second_lesson ()
	{
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		Object.ClickTheSecondLesson();
	}

}
