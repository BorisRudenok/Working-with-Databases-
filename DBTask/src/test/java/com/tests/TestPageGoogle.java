package com.tests;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import com.db.DbHandler;
import com.pages.PageGoogle;
import com.utils.ConfigConst;
import com.utils.CurrentTimeUtil;
import com.utils.PojoDb;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;


public class TestPageGoogle {
    private final ConfigConst configConst = new ConfigConst();
    private final PageGoogle pageGoogle = new PageGoogle();
    private final Browser browser = AqualityServices.getBrowser();
    private final DbHandler dbHandler = new DbHandler();
    private final CurrentTimeUtil currentTimeUtil = new CurrentTimeUtil();
    private final String nameEnv = System.getenv(configConst.USERDOMAIN);
    private final static String SELECTTEXT = "Беларусь";
    private final static long Pro = 1;
    private final static long Ses = 1;

    @BeforeClass
    private void setUp() {
        browser.maximize();
        browser.goTo(configConst.Google);
        pageGoogle.state().waitForDisplayed();
    }

    @Test
    public void GoogleTestSearch() {
        pageGoogle.inputText(SELECTTEXT);
        pageGoogle.selectText();
        Assert.assertEquals(pageGoogle.checkText1(), SELECTTEXT, "text does not match");
    }

    @AfterMethod
    private void addResultsToDb(ITestResult result) {
        PojoDb pojoDb = new PojoDb(result.getName(), result.getInstanceName(), browser.getBrowserName().toString(), nameEnv,
                currentTimeUtil.CurrentTime(result.getStartMillis()), currentTimeUtil.CurrentTime(result.getEndMillis()),
                result.getStatus(), Pro, Ses, null, null);
        dbHandler.runTests(pojoDb);
    }

    @AfterClass
    private void out() {
        browser.quit();
    }
}
