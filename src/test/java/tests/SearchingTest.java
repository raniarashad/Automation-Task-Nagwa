package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.SearchingObject;

public class SearchingTest extends TestBase {

	SearchingObject Object;

	// user make Searching and check the result 
	@Test(priority = 1)
	public void SearchingFunction() throws IOException
	{
		Object = new SearchingObject(driver);
		Object.SearchingFunction();

	}
	@Test(priority = 2)
	public void ClickTheSecondLesson () throws IOException
	{
		Object = new SearchingObject(driver);
		Object.ClickTheSecondLesson();
	}
}
