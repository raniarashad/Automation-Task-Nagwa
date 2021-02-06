package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected WebDriver driver;
	
	// Create Contractor 
	public PageBase(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	// click method 
	protected static void ClickButton (WebElement button)
	{
		button.click();
	}
	// sendkey method
	protected static void SetElementText (WebElement TextElement , String Value)
	{
		TextElement.sendKeys(Value);
	}
	// sleep method 
	public void sleep(int seconds) 
	{
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
