package com.tests;


import com.db.DbHandler;
import com.utils.PojoDb;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static aquality.selenium.browser.AqualityServices.getLogger;

import java.sql.SQLException;


public class SimulateTest {
    private final DbHandler dbHandler = new DbHandler();
    private final static String ID = "419";
    private final static String LIM = "10";
    private PojoDb pojoDb;

    @BeforeMethod
    private void selectData() {
        try {
            this.pojoDb = dbHandler.selectDate(ID, LIM);
        } catch (SQLException | ClassNotFoundException e) {
            getLogger().info("SQL run test data failed!", e);
        }
    }

    @Test
    public void TestSimulate() {
        try {
            dbHandler.updateDate(pojoDb);
        } catch (SQLException e) {
            getLogger().info("SQL run test data failed!", e);
        }
    }

    @AfterMethod
    private void removeData() {
        dbHandler.deleteDate(ID);
    }
}
