package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonInnerPage extends PageBase {

	public LessonInnerPage(WebDriver driver) {
		super(driver);
	}

	// get the last element on the lessons menu "Lesson worksheet"
	@FindBy(xpath = "//div[@class='components']/ul/li[last()]")
	WebElement LessonsMenu;

	public void OpenLessonWorksheet()
	{
		//click on the lesson worksheet link
		LessonsMenu.click();
	}
}
