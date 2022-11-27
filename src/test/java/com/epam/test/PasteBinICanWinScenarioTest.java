package com.epam.test;

import com.epam.model.Paste;
import com.epam.page.PasteBinHomePage;
import com.epam.service.PasteCreator;
import org.testng.Assert;
import org.testng.annotations.*;

public class PasteBinICanWinScenarioTest extends BaseTest {

    @Test (description = "creates paste at pastebin.com and tests is paste crated")
    public void createICanWinPaste() {
        webDriver.get(PASTEBIN_URL);
        Paste paste = PasteCreator.withICanWinParametersFromProperty();
        PasteBinHomePage homePage = new PasteBinHomePage(webDriver)
                .writePaste(paste.getPaste())
                .setPasteExpiration(paste.getExpirationTime())
                .setPasteName(paste.getName());
        Assert.assertTrue(homePage.isNewPasteCreated(), "paste is not created");
    }
}
