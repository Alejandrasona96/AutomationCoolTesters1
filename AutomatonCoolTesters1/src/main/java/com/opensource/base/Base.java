package com.opensource.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.asserts.SoftAssert;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class Base {

	/*
	 * constructor
	 * 
	 * @author Ale soria
	 * 
	 * @param
	 * 
	 * @returns
	 * 
	 * @throws
	 */
	private WebDriver driver;

	public Base(WebDriver driver) {
		this.driver = driver;
	}

	/*
	 * reporter
	 * 
	 * @author alejandra.soria
	 */
	public void reporter(String log) {
		Reporter.log(log);
	}

	/*
	 * Set webdriver
	 */
	public WebDriver chromeDriver() {
		System.setProperty(GlobalVariables.CHROME_DRIVER_KEY, GlobalVariables.CHROME_DRIVER_NAME);
		driver = new ChromeDriver();
		return driver;
	}

	/*
	 * Implicitwait
	 */

	public void implicitlyWait(int seconds) {
		try {
			driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Implicitwait (overloading))
	 */

	public void implicitlyWait() {
		try {
			driver.manage().timeouts().implicitlyWait(GlobalVariables.GENERAL_IMPLICITY_TIMEOUT, TimeUnit.SECONDS);
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * Wait for element present (sync)
	 */

	public void waitForElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, GlobalVariables.GENERAL_TIMEOUT);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}
	/*
	 * Wait for element present (sync) (overloading)
	 */

	public void waitForElementPresent(By locator, int timeout) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
	}

	/*
	 * launch browser
	 */
	public void launchBrowser(String url) {
		reporter("launch browser  " + url);
		driver.get(url);
		driver.manage().window().maximize();
		implicitlyWait();
		takeScreenshot("Launchbrowser");
	}

	/*
	 * TYPE
	 */
	public void type(By locator, String inputText) {
		try {
			driver.findElement(locator).sendKeys(inputText);
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}
	/*
	 * CLICK
	 */

	public void click(By locator) {
		try {
			driver.findElement(locator).click();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
	}

	/*
	 * is displayed
	 */
	public boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * get text
	 */
	public String getText(By locator) {
		try {
			return driver.findElement(locator).getText();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * hard assertion (string)
	 */
	public void assertEquals(String actualValue, String expectedValue) {
		try {
			Assert.assertEquals(actualValue, expectedValue);
		} catch (AssertionError e) {
			Assert.fail(
					e.getMessage() + "Actual value " + actualValue + " does not match expected value" + expectedValue);
		}
	}

	/*
	 * Soft Assertion
	 */
	public SoftAssert softEquals(String actualValue, String expectedValue) {
		try {
			SoftAssert soft = new SoftAssert();
			soft.assertEquals(actualValue, expectedValue);
			return soft;
		} catch (AssertionError e) {
			Assert.fail(
					e.getMessage() + "Actual value " + actualValue + " does not match expected value" + expectedValue);
			return null;
		}
	}

	/*
	 * Close browser
	 */
	public void closeBrowser() {
		driver.close();
	}

	/*
	 * Get Data from JSON file (Directly)
	 * 
	 * @author Ricardo Avalos
	 * 
	 * @param jsonFile, jsonKey
	 * 
	 * @return jsonValue
	 * 
	 * @throws FileNotFoundException
	 */
	public String getJSONValue(String jsonFileObj, String jsonKey) {
		try {

			// JSON Data
			InputStream inputStream = new FileInputStream(GlobalVariables.PATH_JSON_DATA + jsonFileObj + ".json");
			JSONObject jsonObject = new JSONObject(new JSONTokener(inputStream));

			// Get Data
			String jsonValue = (String) jsonObject.getJSONObject(jsonFileObj).get(jsonKey);
			return jsonValue;

		} catch (FileNotFoundException e) {
			Assert.fail("JSON file is not found");
			return null;
		}
	}

	/*
	 * Get Value from Excel
	 * 
	 * @author Ricardo Avalos
	 * 
	 * @date 02/18/2019
	 */
	public String getCellData(String excelName, int row, int column) {
		try {
			// Reading Data
			FileInputStream fis = new FileInputStream(GlobalVariables.PATH_EXCEL_DATA + excelName + ".xlsx");
			// Constructs an XSSFWorkbook object
			@SuppressWarnings("resource")
			Workbook wb = new XSSFWorkbook(fis);
			Sheet sheet = wb.getSheetAt(0);
			Row rowObj = sheet.getRow(row);
			Cell cell = rowObj.getCell(column);
			String value = cell.getStringCellValue();
			return value;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e1) {
			e1.printStackTrace();
			return null;
		}
	}

	/*
	 * Take screenshot
	 * @author Ricardo Avalos
	 * @throws IOException
	 */
	public String takeScreenshot(String fileName) {
		try {
			String pathFileName = GlobalVariables.PATH_SCREENSHOTS + fileName + ".png";
			Screenshot screenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(screenshot.getImage(), "PNG", new File(pathFileName));
			return pathFileName;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}

	}

}
