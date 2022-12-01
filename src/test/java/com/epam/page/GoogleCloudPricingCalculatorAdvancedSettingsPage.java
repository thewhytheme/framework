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

public class GoogleCloudPricingCalculatorAdvancedSettingsPage extends AbstractPage {
    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGPUsCheckBox;
    @FindBy(xpath = "//md-select[@placeholder='GPU type']")
    private WebElement typeOfGPUDropBox;
    @FindBy(xpath = "//md-select[@placeholder='Number of GPUs']")
    private WebElement numberOfGPUsDropBox;
    @FindBy(xpath = "//md-select[@placeholder='Local SSD']")
    private WebElement chooseSSDDropBox;
    @FindBy(xpath = "//md-select[@placeholder='Datacenter location']")
    private WebElement locationDropBox;
    @FindBy(xpath = "//md-select[@placeholder='Committed usage']")
    private WebElement committedUsageDropBox;
    @FindBy(xpath = "//*[@ng-click='listingCtrl.addComputeServer(ComputeEngineForm);']")
    private WebElement estimateButton;
    private final Logger log = LogManager.getRootLogger();

    public GoogleCloudPricingCalculatorAdvancedSettingsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudPricingCalculatorAdvancedSettingsPage addGPUs(boolean gpuStatus, String typeOfGPU, String numberOfGPU) {
        scrollWithFrameSelection();
        if (!gpuStatus) {
            return this;
        }
        addGPUsCheckBox.click();
        getClickableElementEightSecondsWait(typeOfGPUDropBox).click();
        WebElement type = driver.findElement(By.xpath("//md-option/div[contains(text(),'" + typeOfGPU + "')]"));
        getClickableElementEightSecondsWait(type).click();
        getClickableElementEightSecondsWait(numberOfGPUsDropBox).click();
        WebElement number = driver.findElement(By
                .xpath("//div[@id='select_container_469']/md-select-menu/md-content/md-option[@value='" + numberOfGPU + "']"));
        getClickableElementEightSecondsWait(number).click();
        return this;
    }

    private void scrollWithFrameSelection() {
        driver.switchTo().defaultContent();
        scrollDown(350);
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
    }

    public GoogleCloudPricingCalculatorAdvancedSettingsPage setSSDCapacity(String ssdCapacity) {
        scrollWithFrameSelection();
        chooseSSDDropBox.click();
        WebElement capacity = driver.findElement(By.xpath("//md-option/div[contains(text(),'" + ssdCapacity + "')]"));
        getClickableElementEightSecondsWait(capacity).click();
        return this;
    }

    public GoogleCloudPricingCalculatorAdvancedSettingsPage setDataCenterLocation(String location) {
        locationDropBox.click();
        WebElement locElement = driver.
                findElement(By.xpath("//md-option[@value='" + location + "' and @ng-repeat='item in listingCtrl.fullRegionList | filter:listingCtrl.inputRegionText.computeServer']"));
        getClickableElementEightSecondsWait(locElement).click();
        return this;
    }

    public GoogleCloudPricingCalculatorAdvancedSettingsPage setUsageTerm(String term) {
        committedUsageDropBox.click();
        WebElement termElem = new WebDriverWait(driver, Duration.ofSeconds(FIVE_SECONDS_TIMEOUT))
                .until(ExpectedConditions.presenceOfElementLocated(By
                        .xpath("//md-option[contains(@id,'select_option_12') and contains(@value, '" + term + "')]")));
        getClickableElementEightSecondsWait(termElem).click();
        return this;
    }

    public GoogleCloudEstimatedPage estimate() {
        estimateButton.click();
        log.info("Estimation is complete");
        return new GoogleCloudEstimatedPage(driver);
    }
}
