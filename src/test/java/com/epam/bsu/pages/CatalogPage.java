package com.epam.bsu.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CatalogPage extends AbstractPage
{
    private final Logger logger = Logger.getLogger(LoginPage.class);
    private final String BASE_URL = "http://dburn.ru/catalog/item126.html";

    @FindBy(xpath = "id('user_control')/div[1]")
    private WebElement buttonCamera;

    public CatalogPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void clickOnAddCamera()
    {
        buttonCamera.click();
        logger.info("add camera performed");
    }

    public void clickOnDelCamera()
    {
        buttonCamera.click();
        logger.info("delete camera performed");
    }

    @Override
    public void openPage()
    {
        driver.navigate().to(BASE_URL);
        logger.info("CatalogPage page opened");
    }
}
