package steps;


import io.cucumber.java.en.Then;
import pages.WorkSheetPage;
import tests.TestBase;

public class CountQuestions extends TestBase {

	WorkSheetPage object ;
	
	@Then(": Counting the questions then print it on the console")
	public void Counting_the_questions_then_print_it_on_the_console()
	{
		object = new WorkSheetPage(driver);
		object.QuestionsCount();
	}
}
