package com.epam.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleCloudHomePage extends AbstractPage {
    @FindBy(className = "devsite-search-form")
    private WebElement searchButton;
    @FindBy(xpath = "//input[@aria-label='Search']")
    private WebElement searchBar;
    @FindBy(xpath = "//a[@data-ctorig='https://cloud.google.com/products/calculator']")
    private WebElement linkToCalculator;

    public GoogleCloudHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public GoogleCloudHomePage searchForPricingCalculator() {
        getClickableElement(searchButton).click();
        getClickableElement(searchBar).sendKeys("Google Cloud Platform Pricing Calculator");
        searchBar.submit();
        return this;
    }
    public GoogleCloudPricingCalculatorPage enterCalculatorPage() {
        getClickableElement(linkToCalculator).click();
        return new GoogleCloudPricingCalculatorPage(driver);
    }
}
