package tests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import utilities.Helper;

public class TestBase extends AbstractTestNGCucumberTests {

	public static WebDriver driver;
	public String path = System.getProperty("user.dir");   // return project folder path

	// this method will run before each suite
	@BeforeSuite
	// the browser name will be taken from the TestNG file and if it is not exist the chrome browser will be the optional one.
	@Parameters({"browser"})
	public void StartDriver (@Optional("chrome") String browserName) throws IOException
	{
		// ignorecase -- ignore case from name B or b
		if (browserName.equalsIgnoreCase("chrome"))
		{
			String driverpath = path + "\\Drivers\\chromedriver.exe";   // return driver folder path 
			System.setProperty("webdriver.chrome.driver",driverpath ); 
			driver = new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("Firefox"))
		{
			String path = System.getProperty("user.dir");   // return project folder path
			String driverpath = path + "\\Drivers\\geckodriver.exe";   // return driver folder path 
			System.setProperty("webdriver.gecko.driver",driverpath );
			driver = new FirefoxDriver();
		}

		// maximize the the browser instance
		driver.manage().window().maximize();
		// navigate to website URL by entering the url while running the script
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Please Enter the Website URL : ");
		String URL = reader.readLine();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	// this method will run after each suite
	@AfterSuite(enabled = true)
	public void StopDriver()
	{
		driver.quit();
	}

	// Take screen shot when testcase fail and add it in the screenshots folder 
	@AfterMethod 
	public void ScreenShot (ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			System.out.println("Failed!");
			System.out.println("Taking Failed screenshot......");
			Helper.CaptureScreenShot(driver, result.getName());
		}
	}
}
