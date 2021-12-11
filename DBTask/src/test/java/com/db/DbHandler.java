package com.db;


import com.google.inject.Singleton;
import com.utils.ConfigConst;
import com.utils.CurrentTimeUtil;
import com.utils.PojoDb;

import static aquality.selenium.browser.AqualityServices.getLogger;

import java.sql.*;


public class DbHandler {
    private final CurrentTimeUtil currentTimeUtil = new CurrentTimeUtil();
    private final ConfigConst configConst = new ConfigConst();

    private Connection getDbUnionReportingConnection() throws SQLException, ClassNotFoundException {
        return getDbConnection(configConst.dbPath,
                configConst.dbHost,
                configConst.dbPort,
                configConst.dbName,
                configConst.username,
                configConst.password);
    }

    @Singleton
    private Connection getDbConnection(String dbPath,
                                       String dbHost,
                                       String dbPort,
                                       String dbName,
                                       String username,
                                       String password)
            throws SQLException {
        String connectionParameters = String.format("%s %s:%s/%s", dbPath, dbHost, dbPort, dbName);

        return DriverManager.getConnection(connectionParameters, username, password);
    }

    public void runTests(PojoDb pojoDb) {
        String insert = String.format("INSERT %s(%s,%s,%s,%s,%s,%s,%s,%s,%s) VALUES(?,?,?,?,?,?,?,?,?)",
                                        Const.TEST_TABLE,
                                        Const.NAME,
                                        Const.METHOD_NAME,
                                        Const.BROWSER,
                                        Const.ENV,
                                        Const.START_TIME,
                                        Const.END_TIME,
                                        Const.STATUSID,
                                        Const.PROJECTID,
                                        Const.SESSIONID);
        try {
            PreparedStatement prST = getDbUnionReportingConnection().prepareStatement(insert);
            prST.setString(1, pojoDb.getName());
            prST.setString(2, pojoDb.getMethodName());
            prST.setString(3, pojoDb.getBrowser());
            prST.setString(4, pojoDb.getEnv());
            prST.setString(5, pojoDb.getStartTime());
            prST.setString(6, pojoDb.getEndTime());
            prST.setString(7, pojoDb.getStatusId().toString());
            prST.setString(8, pojoDb.getProjectId().toString());
            prST.setString(9, pojoDb.getSessionId().toString());
            prST.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            getLogger().info("SQL run test data failed!", e);

        }
    }


    public void deleteDate(String sampleDataForDelete) {
        String delete = String.format("DELETE FROM  %s  WHERE %s  = " + sampleDataForDelete,
                Const.TEST_TABLE, Const.ID);
        try {
            PreparedStatement prST = getDbUnionReportingConnection().prepareStatement(delete);
            prST.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            getLogger().info("SQL delete date failed!", e);
        }
    }

    public PojoDb selectDate(String sampleData, String limit) throws SQLException, ClassNotFoundException {
        String select = String.format("SELECT * FROM %s WHERE %s = %s LIMIT %s;",
                Const.TEST_TABLE, Const.ID, sampleData, limit);
        PreparedStatement prST = getDbUnionReportingConnection().prepareStatement(select);
        ResultSet ser = prST.executeQuery();
        return parsDataToString(ser);
    }


    private PojoDb parsDataToString(ResultSet resultSet) throws SQLException {
        resultSet.next();
        PojoDb pojoDb = new PojoDb(resultSet.getString("name"),
                resultSet.getString("method_name"),
                resultSet.getString("browser"),
                resultSet.getString("env"),
                resultSet.getString("start_time"),
                resultSet.getString("end_time"),
                resultSet.getInt("status_id"),
                resultSet.getLong("project_id"),
                resultSet.getLong("session_id"),
                resultSet.getLong("id"),
                resultSet.getLong("author_id"));
        return pojoDb;

    }

    public void updateDate(PojoDb pojoDb) throws SQLException {
        String nameEnv = System.getenv(configConst.USERDOMAIN);
        pojoDb.setStartTime(currentTimeUtil.CurrentTime(System.currentTimeMillis()));
        pojoDb.setEndTime(currentTimeUtil.CurrentTime(System.currentTimeMillis()));
        pojoDb.setEnv(nameEnv);
        String update = String.format("UPDATE %s SET %s = '%s', %s = '%s', %s = '%s' WHERE %s = %s",
                                        Const.TEST_TABLE,
                                        Const.START_TIME,
                                        pojoDb.getStartTime(),
                                        Const.END_TIME,
                                        pojoDb.getEndTime(),
                                        Const.ENV, nameEnv,
                                        Const.ID,
                                        pojoDb.getId());
        try {
            PreparedStatement prST = getDbUnionReportingConnection().prepareStatement(update);
            prST.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            getLogger().info("SQL update date failed!", e);
        }
    }
}