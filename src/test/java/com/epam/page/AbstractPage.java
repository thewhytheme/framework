package com.epam.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public abstract class AbstractPage {
    protected WebDriver driver;
    protected static final int FIVE_SECONDS_TIMEOUT = 5;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
    }

    protected void scrollDown(int pixelAmount) {
        JavascriptExecutor jsExec = (JavascriptExecutor) driver;
        jsExec.executeScript("window.scrollBy(0," + pixelAmount + ")");

    }

    protected WebElement getClickableElement(By path) {
        return new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_TIMEOUT))
                .until(ExpectedConditions.elementToBeClickable(path));
    }

    protected WebElement getClickableElement(WebElement element) {
        return new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
