package com.epam.test;

import com.epam.driver.DriverSingleton;
import com.epam.utils.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners(TestListener.class)
public class BaseTest {
    protected WebDriver webDriver;
    protected static final String PASTEBIN_URL = "https://pastebin.com/";

    @BeforeTest
    public void setUp() {
        webDriver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        DriverSingleton.closeDriver();
    }
}
