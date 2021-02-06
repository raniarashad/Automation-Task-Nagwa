package tests;

import org.testng.annotations.Test;

import pages.WorkSheetPage;

public class WorkSheetTests extends TestBase {

	WorkSheetPage object ;
	
	// Count the questions method
	@Test
	public void CountingQuestions ()
	{
		object = new WorkSheetPage(driver);
		object.QuestionsCount();
	}
}
