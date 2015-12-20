package com.epam.bsu.steps;

import java.util.concurrent.TimeUnit;

import com.epam.bsu.pages.CatalogPage;
import com.epam.bsu.pages.SettingsPage;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.epam.bsu.pages.LoginPage;
import com.epam.bsu.pages.MainPage;

public class Steps
{
	private WebDriver driver;
	private final Logger logger = Logger.getLogger(Steps.class);

	public void initBrowser()
	{
		driver = new FirefoxDriver();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		BasicConfigurator.configure();
		logger.info("Browser started");
	}

	public void closeDriver()
	{
		driver.quit();
		logger.info("close driver");
	}

	public void loginDburn(String username, String password)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.openPage();
		loginPage.login(username, password);
	}

	public boolean isLoggedIn(String username)
	{
		LoginPage loginPage = new LoginPage(driver);
		return (loginPage.getLoggedInUserName().trim().toLowerCase().equals(username));
	}

	public boolean isLoggedOut(String name)
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.logOut();
		return (loginPage.getLinkRegistration().trim().toLowerCase().equals(name));
	}

	public boolean addCamera(String cameraName)
	{
		CatalogPage catalogPage = new CatalogPage(driver);
		catalogPage.openPage();
		catalogPage.clickOnAddCamera();
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		return (mainPage.getCameraName().trim().toLowerCase().equals(cameraName));
	}

	public boolean delCamera(String name)
	{
		CatalogPage catalogPage = new CatalogPage(driver);
		catalogPage.openPage();
		catalogPage.clickOnDelCamera();
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		return (mainPage.getStringNoEquipment().trim().toLowerCase().equals(name));
	}

	public boolean editSettings(String city)
	{
		SettingsPage settingsPage = new SettingsPage(driver);
		settingsPage.openPage();
		String expectedCityName = settingsPage.clickOnAddCity(city);
		MainPage mainPage = new MainPage(driver);
		mainPage.openPage();
		return (mainPage.getCityUser().equals(expectedCityName));
	}


}
