package com.utils;


import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;


public class ConfigManager {
    private static Properties PROPERTIESTesTData;
    private static Properties PROPERTIESConf;
    private static final String PathConf = "src/test/resources/conf.properties";
    private static final String TestData = "src/test/resources/data.properties";

    static {
        try (FileReader fileInputStreamConf = new FileReader(PathConf);
             FileReader fileInputStreamTesTData = new FileReader(TestData)) {
            PROPERTIESConf = new Properties();
            PROPERTIESConf.load(fileInputStreamConf);
            PROPERTIESTesTData = new Properties();
            PROPERTIESTesTData.load(fileInputStreamTesTData);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getPropertyConf(String key) {
        return PROPERTIESConf.getProperty(key);
    }

    public static String getPropertyTestData(String key) {
        return PROPERTIESTesTData.getProperty(key);
    }
}
