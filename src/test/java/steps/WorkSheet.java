package steps;

import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LessonInnerPage;
import tests.TestBase;

public class WorkSheet extends TestBase {

	LessonInnerPage InnerObject;
	
	@When(": Click on the lesson work sheet")
	public void Click_on_the_lesson_work_sheet()
	{
		InnerObject = new LessonInnerPage(driver);
		InnerObject.OpenLessonWorksheet();
	}
	
	@Then(": User will open the work sheet page")
	public void User_will_open_the_work_sheet_page()
	{
		// verify that the work sheet page is opened correctlys
		Assert.assertTrue(driver.getCurrentUrl().contains("worksheets"));

	}
}
