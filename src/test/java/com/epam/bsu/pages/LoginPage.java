package com.epam.bsu.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "http://dburn.ru/";

	@FindBy(id = "login")
	private WebElement inputLogin;

	@FindBy(id = "pass")
	private WebElement inputPassword;

	@FindBy(id = "login_btn")
	private WebElement buttonSubmit;

	@FindBy(xpath = "id('left_side')/div/noindex[1]/div/div/table/tbody/tr[16]/td[2]/a")
	private WebElement buttonLogOut;

	@FindBy(xpath = "id('upr_profile')/div/h1")
	private WebElement linkLoggedInUser;

	@FindBy(xpath = "id('authform')/div[2]/a")
	private WebElement linkRegistration;


	public LoginPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("Login page opened");
	}

	public void login(String username, String password)
	{
		inputLogin.sendKeys(username);
		inputPassword.sendKeys(password);
		buttonSubmit.click();
		logger.info("Login performed");
	}

	public void logOut()
	{
		buttonLogOut.click();
		logger.info("Logout performed");
	}

	public String getLoggedInUserName()
	{
		return linkLoggedInUser.getText();
	}

	public String getLinkRegistration()
	{
		return linkRegistration.getText();
	}

}
