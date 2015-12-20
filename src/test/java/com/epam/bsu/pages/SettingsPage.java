package com.epam.bsu.pages;

import com.epam.bsu.utils.Utils;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class SettingsPage extends AbstractPage
{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://dburn.ru/users/130483/editprofile.html";

    @FindBy(id = "city")
    private WebElement inputCity;

    @FindBy(id = "save")
    private WebElement buttonSave;

    public SettingsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public String clickOnAddCity(String city)
    {
        String cityName = city + Utils.getRandomString(3);
        inputCity.clear();
        inputCity.sendKeys(cityName);
        buttonSave.click();
        logger.info("add city performed");
        return cityName;
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("SettingsPage page opened");
    }

}
