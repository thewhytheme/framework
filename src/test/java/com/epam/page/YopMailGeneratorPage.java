package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class YopMailGeneratorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(id = "egen")
    private WebElement emailElement;
    @FindBy(xpath = "//*[@onclick='egengo();']")
    private WebElement checkEmailButton;
    @FindBy(xpath = "//h2[text()]")
    private WebElement mailSum;
    @FindBy(id = "refresh")
    private WebElement refreshButton;

    public YopMailGeneratorPage(WebDriver yopDriver) {
        super(yopDriver);
        PageFactory.initElements(yopDriver, this);
    }

    public String getGeneratedEmailText() {
        return emailElement.getText();
    }

    public String checkEmail() {
        int count = 0;
        checkEmailButton.click();
        captchaCheck();
        WebElement text = new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='message']")));
        while ((text.getAttribute("innerText").contains("Этот почтовый ящик пуст")) || count < 2) {
            getClickableElementEightSecondsWait(refreshButton).click();
            count++;
        }
        driver.switchTo().frame("ifmail");
        return mailSum.getText();
    }

    private void captchaCheck() {
        try {
            new WebDriverWait(driver, Duration.ofSeconds(6))
                    .until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(By
                            .xpath("//iframe[starts-with(@name, 'a-') and starts-with(@src, 'https://www.google.com/recaptcha')]")));
            getClickableElementFiveSecondsWait(By
                    .xpath("//span[@class='recaptcha-checkbox goog-inline-block recaptcha-checkbox-unchecked rc-anchor-checkbox']")).click();
            logger.warn("reCaptcha was caught");
        } catch (org.openqa.selenium.NoSuchElementException | TimeoutException ignored) {

        }
    }
}
