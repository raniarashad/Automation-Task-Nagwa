package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkSheetPage extends PageBase {

	public WorkSheetPage(WebDriver driver) {
		super(driver);
		Driver = driver;
	}
	WebDriver Driver;
	
	// finding the questions list and store it on the list of webelements
	@FindBy(css = ".instances div .question-number")
	List<WebElement> QuestionsList;
	
	public void QuestionsCount()
	{
		int NumberOfQuestions = QuestionsList.size(); // get size of the list (number of questions)
		System.out.println("The number of questions of the second lesson on the search result : " + NumberOfQuestions + " Questions"); //print the number of questions
	}
	
}
