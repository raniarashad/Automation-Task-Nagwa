package tests;

import org.testng.annotations.Test;

import pages.LessonInnerPage;

public class LeasonInnerPageTests extends TestBase {

	LessonInnerPage object ;
	
	// open the lesson worksheet page
	@Test
	public void InnerLeason ()
	{
		object = new LessonInnerPage(driver);
		object.OpenLessonWorksheet();
	}
}
