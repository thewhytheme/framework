package com.epam.test;

import com.epam.model.Paste;
import com.epam.page.PasteBinCreatedPastePage;
import com.epam.page.PasteBinHomePage;
import com.epam.service.PasteCreator;
import org.testng.Assert;
import org.testng.annotations.*;

public class PasteBinBringItOnScenarioTest extends BaseTest {
    private Paste pasteEntity;
    private PasteBinHomePage homePage;

    @BeforeClass(description = "creates paste at pastebin.com with Bring It On scenario parameters")
    public void createNewPasteBinPaste() {
        webDriver.get(PASTEBIN_URL);
        pasteEntity = PasteCreator.withBringItOnParametersFromProperty();
        homePage = new PasteBinHomePage(webDriver);
        homePage.writePaste(pasteEntity.getPaste())
                .setFormatHighlighter(pasteEntity.getHighlighting())
                .setPasteExpiration(pasteEntity.getExpirationTime())
                .setPasteName(pasteEntity.getName())
                .isNewPasteCreated();
    }

    @Test(description = "pulls name of paste from created paste page and compares it with source paste name value", priority = 1)
    public void isPasteNameEqualsExpected() {
        Assert.assertEquals(homePage.retrievePasteNameFromInfoTop(), pasteEntity.getName(), "Paste name is not matched");
    }

    @Test(description = "searches link on bash paste archive after paste creation and tests if its displayed", priority = 2)
    public void isSyntaxHighlightedForBash() {
        Assert.assertTrue(new PasteBinCreatedPastePage(webDriver)
                .isBashArchiveLinkPresent(), "Syntax is not highlighted for bash");
    }

    @Test(description = "compares on equality created paste and source paste code", priority = 3)
    public void isPasteCodeEqualsExpected() {
        String postedText = new PasteBinCreatedPastePage(webDriver).getPasteTextArea()
                .getAttribute("innerText").replace("\u00a0", "").trim();
        Assert.assertEquals(postedText, pasteEntity.getPaste().trim(), "Text not equal!");
    }

}
