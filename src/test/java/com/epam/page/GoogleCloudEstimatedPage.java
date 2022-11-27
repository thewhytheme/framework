package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.*;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class GoogleCloudEstimatedPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final YopMailGeneratorPage yopMailGeneratorPage;
    @FindBy(xpath = "//b[@class='ng-binding']")
    private WebElement cost;
    @FindBy(xpath = "//button[@title='Email Estimate']")
    private WebElement emailButton;
    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement emailTextBox;
    private ArrayList<String> tabs;

    public GoogleCloudEstimatedPage(WebDriver driver) {
        super(driver);
        yopMailGeneratorPage = new YopMailGeneratorPage(driver);
        PageFactory.initElements(driver, this);
    }

    public String findAndGetComputeEngineEstimationText() {
        return new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//md-list[@class='cartitem ng-scope']"))).getText();
    }

    public GoogleCloudEstimatedPage chooseEmailEstimateOption() {
        getClickableElement(emailButton).click();
        return this;
    }

    public GoogleCloudEstimatedPage openEmailGenerator() {
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to("https://yopmail.com/ru/email-generator");
        return this;
    }

    public GoogleCloudEstimatedPage copyLinkAndPassItToEstimatedPage() {
        String email = yopMailGeneratorPage.getGeneratedEmailText();
        tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
        new GoogleCloudPricingCalculatorPage(driver).switchToAFrame();
        emailTextBox.sendKeys(email);
        return this;
    }

    public GoogleCloudEstimatedPage sendEstimationOnEmail() {
        scrollFormToSendEmailButton();
        new WebDriverWait(driver, Duration.ofSeconds(8))
                .until(ExpectedConditions.visibilityOfElementLocated(By
                        .xpath("//button[@aria-label='Send Email']"))).click();
        logger.info("email with estimation was sent");
        return this;
    }

    private void scrollFormToSendEmailButton() {
        driver.switchTo().defaultContent();
        scrollDown(450);
        driver.switchTo().frame(driver
                .findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
    }

    public String getEstimationSumFromEmail() {
        driver.switchTo().window(tabs.get(1));
        return yopMailGeneratorPage.checkEmail();
    }

    public String getCalculatedCost() {
        return cost.getText();
    }
}
