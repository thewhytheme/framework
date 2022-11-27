package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class PasteBinCreatedPastePage extends AbstractPage {
    private static final String BASH_ARCHIVE_LINK = "//a[@href='/archive/bash']";
    private static final String HIGHLIGHTED_AREA = "//ol[@class = 'bash']";

    public PasteBinCreatedPastePage(WebDriver driver) {
        super(driver);
    }

    public boolean isBashArchiveLinkPresent() {
        return getPresentedElement(BASH_ARCHIVE_LINK).isDisplayed();
    }

    private WebElement getPresentedElement(String xpath) {
        return new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
    }

    public WebElement getPasteTextArea() {
        return getPresentedElement(HIGHLIGHTED_AREA);
    }
}
