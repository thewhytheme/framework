package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;


public class PasteBinHomePage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private static final String TEXT_AREA_TAG_NAME = "textarea";
    private static final String NAME_AREA_TAG_XPATH = "//input[@id='postform-name']";

    @FindBy(tagName = TEXT_AREA_TAG_NAME)
    private WebElement textArea;
    @FindBy(xpath = NAME_AREA_TAG_XPATH)
    private WebElement nameArea;

    public PasteBinHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public PasteBinHomePage writePaste(String paste) {
        getPresentedElement(By.tagName(TEXT_AREA_TAG_NAME)).click();
        textArea.sendKeys(paste);
        scrollDown(650);
        return this;
    }

    public PasteBinHomePage setPasteExpiration(String expirationTime) {
        String buttonXpath = "//li[text()='" + expirationTime + "']";
        getClickableElement(By.id("select2-postform-expiration-container")).click();
        getClickableElement(By.xpath(buttonXpath)).click();
        return this;
    }

    public PasteBinHomePage setPasteName(String pasteName) {
        getPresentedElement(By.xpath(NAME_AREA_TAG_XPATH)).click();
        nameArea.sendKeys(pasteName);
        return this;
    }

    private WebElement getPresentedElement(By path) {
        return new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(path));
    }

    public Boolean isNewPasteCreated() {
        scrollDown(200);
        getPresentedElement(By.xpath("//*[text()='Create New Paste']")).click();
        logger.info("New paste was created");
        return getPresentedElement(By.xpath("//div[@class='notice -success -post-view']")).isDisplayed();
    }

    public PasteBinHomePage setFormatHighlighter(String formatHighlighter) {

        String highlighterXpath = "//ul/li[text()='" + formatHighlighter + "']";
        getClickableElement(By.id("select2-postform-format-container")).click();
        driver.findElement(By.xpath(highlighterXpath)).click();
        return this;
    }


    public String retrievePasteNameFromInfoTop() {
        return getClickableElement(By.xpath("//div[@class='info-top']")).getAttribute("innerText");
    }
}
