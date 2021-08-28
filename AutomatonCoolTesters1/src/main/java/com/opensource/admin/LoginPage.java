package com.opensource.admin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opensource.base.Base;

public class LoginPage extends Base{

	public LoginPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
 
	//Objects
	By txtUsername = By.xpath("//input[@id='txtUsername']");
	By txtPassword = By.xpath("//input[@id='txtPassword']");
	By btnLogin = By.xpath("//input[@id='btnLogin']");
	By lnkWelcome = By.xpath("//a[@id='welcome']");
	By lnkLogout = By.xpath("//a[contains(text(),'Logout')]");
	
	/*
	 * LoginOrangeHRM
	 * @AUTHOR Alejandra.soria
	 * @date 08142021
	 */
	public void loginOrange (String username, String password) {
		reporter("Enter user and password");
		type(txtUsername, username); //recibe objeto y parámetro
		type(txtPassword, password);
		takeScreenshot("EnterUserPass");
		click(btnLogin);//solo recibe el objeto
		implicitlyWait();
	
	}
	
	public void logOutOrange () {
		reporter("logout Orage HRM Portal...");
		click(lnkWelcome);
		click(lnkLogout);
		takeScreenshot("LogOut");
		implicitlyWait();
		closeBrowser();
	}
	

}
