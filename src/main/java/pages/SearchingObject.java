package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchingObject extends PageBase{

	public SearchingObject(WebDriver driver) {
		super(driver);
		Driver = driver;
	}
	WebDriver Driver;
	String SearchKeyword;
	String path = System.getProperty("user.dir");   // return project folder path

	// finding the search icon element 
	@FindBy(className = "search")
	WebElement SearchIcon;

	// finding the search input text box element
	@FindBy(id = "txt_search_query")
	WebElement SearchingInput;

	// Accept WebSite cookies button
	@FindBy(id = "btn_cookie_accept")
	WebElement AcceptCookiesBtn;

	// retrieve the list of lessons name that is displaying after searching and store them on the list of webelement
	@FindBy(css = ".list li div a")
	List <WebElement> lessonNames;

	// this method to read the searching keyword from the excel sheet
	public void ReadDataFromExcel () throws IOException {

		String SheetPath = path + "\\src\\test\\java\\utilities\\Data.xlsx";  	// sheet path that contains the searching keyword
		File src = new File(SheetPath);
		// read the data from the excel sheet 
		FileInputStream fis = new FileInputStream(src);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sheet11 = wb.getSheetAt(0);
		// get the searching keyword from the excel sheet and store it in string
		SearchKeyword = sheet11.getRow(1).getCell(0).getStringCellValue();
	}

	// searching for the keyword that is entered on the excel sheet 
	public void SearchingFunction () throws IOException 
	{
		sleep(5);
		ClickButton(AcceptCookiesBtn); // Click the accept cookies button
		ClickButton(SearchIcon); // click on the search icon
		ReadDataFromExcel(); // call read from excel sheet method
		SearchingInput.sendKeys(SearchKeyword); // enter the searching keyword in the search input
		SearchingInput.sendKeys(Keys.ENTER); // Click enter	
		List<WebElement> result = Driver.findElements(By.cssSelector(".list li div")); // store the search result on the list of webelements
		String SheetPath = path + "\\src\\test\\java\\utilities\\LeasonsSearchingResult.xlsx"; // declare the sheet path that the search result will be stored in it
		File source  = new File(SheetPath);
		//write the result list on the excel sheet
		FileInputStream input = new FileInputStream(source);
		XSSFWorkbook wb = new XSSFWorkbook(input);
		XSSFSheet sheet = wb.getSheetAt(0);
		for (int i = 0 ; i <result.size(); i++)
		{
			String leasonsResult = result.get(i).getText();
			sheet.createRow(i).createCell(0).setCellValue(leasonsResult);
		}
		FileOutputStream output = new FileOutputStream(source);
		wb.write(output);
		wb.close();

		// get the rows count and for loop on the rows count to verify that all rows contains on the search keyword
		int rowcount = sheet.getLastRowNum();
		for(int j =0; j<rowcount; j++)
		{
			String CellValue = sheet.getRow(j).getCell(0).getStringCellValue();
			CellValue.contains(SearchKeyword);
		}
		System.out.println("Result count: " + rowcount + " All searching result contains on the searching keyword");
	}

	// Click on 2nd lesson in the search results 
	public void ClickTheSecondLesson()
	{
		lessonNames.get(1).click();

	}
}
