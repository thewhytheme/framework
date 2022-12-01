package com.epam.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
public class GoogleCloudPricingCalculatorPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    @FindBy(xpath = "//md-tab-item/div[@title='Compute Engine']")
    private WebElement computeEngineButton;
    @FindBy(id = "input_90")
    private WebElement numberOfInstancesTextBox;
    @FindBy(id = "select_value_label_82")
    private WebElement operationSystemDropBox;
    @FindBy(xpath = "//md-select[@placeholder='VM Class']")
    private WebElement virtualMachineDropBox;
    @FindBy(id = "select_value_label_85")
    private WebElement machineSeriesDropBox;
    @FindBy(xpath = "//md-select[@placeholder='Instance type']")
    private WebElement machineParamDropBox;

    public GoogleCloudPricingCalculatorPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void switchToAFrame() {
        driver.switchTo().defaultContent();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='cloud-site']/devsite-iframe/iframe")));
        driver.switchTo().frame("myFrame");
    }

    public GoogleCloudPricingCalculatorPage activeComputeEngineSection() {
        logger.info("Starting to filling up Cloud Form");
        switchToAFrame();
        getClickableElementEightSecondsWait(computeEngineButton).click();
        return this;
    }

    public GoogleCloudPricingCalculatorPage setNumberOfInstances(String numberOfInstances) {
        getClickableElementEightSecondsWait(numberOfInstancesTextBox).click();
        numberOfInstancesTextBox.sendKeys(numberOfInstances);
        return this;
    }

    public GoogleCloudPricingCalculatorPage setSoftware(String software) {
        operationSystemDropBox.click();
        WebElement softwareElement = driver.findElement(By.xpath("//md-option/div[contains(text(),'" + software + "')]"));
        getClickableElementEightSecondsWait(softwareElement).click();
        return this;

    }

    public GoogleCloudPricingCalculatorPage setProvisioningModel(String vmClass) {
        driver.switchTo().defaultContent();
        scrollDown(300);
        switchToAFrame();
        virtualMachineDropBox.click();
        WebElement vmElement = driver.findElement(By.xpath("//md-option/div[contains(text(),'" + vmClass + "')]"));
        getClickableElementEightSecondsWait(vmElement).click();
        return this;
    }

    public GoogleCloudPricingCalculatorAdvancedSettingsPage setInstanceType(String machineSeries, String machineType) {
        machineSeriesDropBox.click();
        WebElement series = driver.findElement(By.xpath("//md-option/div[contains(text(),'" + machineSeries + "')]"));
        getClickableElementEightSecondsWait(series).click();
        machineParamDropBox.click();
        WebElement type = driver.findElement(By.xpath("//md-option/div[contains(text(),'" + machineType + "')]"));
        getClickableElementEightSecondsWait(type).click();
        return new GoogleCloudPricingCalculatorAdvancedSettingsPage(driver);
    }
}
