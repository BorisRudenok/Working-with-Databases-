package com.utils;

public class ConfigConst {
    public String dbPort = ConfigManager.getPropertyConf("dbPort");
    public String dbHost = ConfigManager.getPropertyConf("dbHost");
    public String dbName = ConfigManager.getPropertyConf("dbName");
    public String dbPath = ConfigManager.getPropertyConf("dbPath");
    public String username = ConfigManager.getPropertyConf("username");
    public String password = ConfigManager.getPropertyConf("password");
    public String USERDOMAIN = ConfigManager.getPropertyConf("env");
    public String Google = ConfigManager.getPropertyTestData("Google");
    public String Time = ConfigManager.getPropertyTestData("time");
}
