package com.epam.service;


import com.epam.model.Paste;

public class PasteCreator {
    public static final String DATA_PASTEBIN_PASTE = "data.bin.paste";
    public static final String DATA_PASTEBIN_NAME = "data.bin.name";
    public static final String DATA_PASTEBIN_EXPIRATION = "data.bin.expiration";
    public static final String DATA_PASTEBIN_HIGHLIGHTING = "data.bin.highlighting";

    public static Paste withPasteOnly() {
        return new Paste(TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_PASTE));
    }

    public static Paste withBringItOnParametersFromProperty() {
        return new Paste(TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_NAME),
                TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_PASTE),
                TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_HIGHLIGHTING),
                TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_EXPIRATION));
    }

    public static Paste withICanWinParametersFromProperty() {
        return new Paste(TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_NAME),
                TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_PASTE),
                "",
                TestDataConfigReader.getEnvironmentData(DATA_PASTEBIN_EXPIRATION));

    }


}
