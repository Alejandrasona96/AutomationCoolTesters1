package com.opensource.admin.qa;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.opensource.admin.AdminPage;
import com.opensource.admin.LoginPage;
import com.opensource.base.Base;
import com.opensource.base.GlobalVariables;

public class TC001_Admin_SearchEmployee_POMTest {
	WebDriver driver;
	Base base;
	LoginPage login;
	AdminPage admin;
	String username, password;
	
@BeforeTest	
public void beforetest() {
	//set up driver
	base = new Base (driver);
	driver = base.chromeDriver();
	login = new LoginPage(driver);
	admin = new AdminPage(driver);
	
//test data Json 
	//this.username = base.getJSONValue(this.getClass().getSimpleName(), "username");
	//this.password = base.getJSONValue(this.getClass().getSimpleName(), "password");
	
//test data excel
		this.username = base.getCellData(this.getClass().getSimpleName(), 1, 0);
		this.password = base.getCellData(this.getClass().getSimpleName(), 1, 1);
}

	
  @Test
  public void TC001_Admin_SearchEmployee_POMTest_script() {
	  //step1
	  base.launchBrowser(GlobalVariables.QA_URL);
	  
	  //step2
	  login.loginOrange(username, password);
	  
	  //step3
	  admin.validateLogin();
	  
	  //step 4-7
	  admin.verifyUserExistsTableAferClickSearch(username);
	  
	  //step 8-9
	  login.logOutOrange();
  }
  
  @AfterTest
  public void afterTest() {
  }
  
}
