package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;

import com.opensource.base.Base;

public class AdminPage extends Base{

	public AdminPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	//Objects
	By imgHeaderOrange = By.xpath("//img[@alt='OrangeHRM']");
	By lnkAdmin = By.xpath("//a[@id='menu_admin_viewAdminModule']");
	By txtSearchUserName = By.xpath("//input[@id='searchSystemUser_userName']");
	By btnSearch = By.xpath("//input[@id='searchBtn']");
	By tblUserName = By.xpath("//tbody/tr[1]/td[2]");
	
	//se hace la validación de que ya estamos logeados
	public void validateLogin() {
		reporter ("Validate logged successfully");
		waitForElementPresent(imgHeaderOrange);
		takeScreenshot("ValidateLogged");
		}
	
	public void clickAdmin() {
		reporter ("click Admin Module");
		click (lnkAdmin);
		implicitlyWait();
		takeScreenshot("ClickAdmin");
		}
	
	public void searchUser(String username) {
		reporter("Searching..." + username);
		type(txtSearchUserName, username);
		click (btnSearch);
		implicitlyWait();	
	}
	
	public void validateUserNameTable (String username) {
		reporter("Verify this value: "+username+"In Admin user table");
		SoftAssert validTable = softEquals (getText(tblUserName), username); //soft assertion
		validTable.assertAll();
		takeScreenshot("ValidateUser");
		//assertEquals(getText(tblUserName), username); //este es un hard assertion
	}
	
	
	/* Verify user exist in table after click search
	 * @params (wrapper)
	 */
	public void verifyUserExistsTableAferClickSearch (String username) {
		clickAdmin();
		searchUser(username);
		validateUserNameTable (username);
	}
}
