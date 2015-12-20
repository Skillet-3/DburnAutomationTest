package com.epam.bsu.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class MainPage extends AbstractPage
{
	private final Logger logger = Logger.getLogger(LoginPage.class);
	private final String BASE_URL = "http://dburn.ru/users/testautomation";

	@FindBy(xpath = "id('user_profile_main_table')/tbody/tr/td/div[2]/div[1]/div[8]")
	private WebElement linkNoEquipment;

	@FindBy(xpath = "id('user_profile_main_table')/tbody/tr/td/div[2]/div[1]/a")
	private WebElement linkCameraSelected;

	@FindBy(xpath = "id('user_profile_main_table')/tbody/tr/td/table/tbody/tr/td[2]/div[3]/div[2]/div[2]/a")
	private WebElement linkCityUser;

	public MainPage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(this.driver, this);
	}

	public String getCameraName()
	{
		return linkCameraSelected.getText();
	}

	public String getStringNoEquipment()
	{
		return linkNoEquipment.getText();
	}

	public String getCityUser()
	{
		return linkCityUser.getText();
	}

	@Override
	public void openPage()
	{
		driver.navigate().to(BASE_URL);
		logger.info("MainPage page opened");
	}
}
