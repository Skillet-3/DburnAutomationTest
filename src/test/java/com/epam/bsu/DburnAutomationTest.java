package com.epam.bsu;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.epam.bsu.steps.Steps;

public class DburnAutomationTest
{
	private Steps steps;
	private final String USERNAME = "testautomation";
	private final String PASSWORD = "testautomationpass";
	private final String CAMERA_NAME = "nikon d3100"; 
	private final String NO_EQUIPMENT = "не указано";
	private final String CITY = "minsk";
	private final String REGISTRATION = "регистрация";

	@BeforeMethod(description = "Init browser")
	public void setUp()
	{
		steps = new Steps();
		steps.initBrowser();
	}

	@Test(description = "Login to dburn")
	public void oneCanLogin()
	{
		steps.loginDburn(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedIn(USERNAME));
	}

	@Test(description = "Add camera in user profile")
	public void oneCanAddCamera()
	{
		steps.loginDburn(USERNAME, PASSWORD);
		Assert.assertTrue(steps.addCamera(CAMERA_NAME));
	}

	@Test(description = "delete camera in user profile")
	public void oneDelCamera()
	{
		steps.loginDburn(USERNAME, PASSWORD);
		Assert.assertTrue(steps.delCamera(NO_EQUIPMENT));
	}

	@Test(description = "edit city in user profile")
	public void oneEditCity()
	{
		steps.loginDburn(USERNAME, PASSWORD);
		Assert.assertTrue(steps.editSettings(CITY));
	}

	@Test(description = "Logout")
	public void oneCanLogout()
	{
		steps.loginDburn(USERNAME, PASSWORD);
		Assert.assertTrue(steps.isLoggedOut(REGISTRATION));
	}

	@AfterMethod(description = "Stop Browser")
	public void stopBrowser()
	{
		steps.closeDriver();
	}

}
