package tests;

import java.io.IOException;

import org.testng.annotations.Test;

import pages.SearchingObject;

public class SearchingTest extends TestBase {

	SearchingObject Object;
	
	// user make Searching and check the result 
	@Test
	public void SearchingFunction()
	{
		Object = new SearchingObject(driver);

		try {
			Object.SearchingFunction();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
