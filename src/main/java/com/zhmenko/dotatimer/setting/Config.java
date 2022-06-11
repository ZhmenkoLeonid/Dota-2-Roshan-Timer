package com.zhmenko.dotatimer.setting;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Config {
    private JsonConfig jsonConfig;

    public Config(String strBefAegExTime, String strBefRoshRecLeftTime,
                  String strBefRoshRecRightTime,
                  boolean usColon,String eChar){
        jsonConfig = new JsonConfig();
        jsonConfig.setStringBeforeAegisExpiredTime(strBefAegExTime);
        jsonConfig.setStringBeforeRoshanRecoveryLeftTime(strBefRoshRecLeftTime);
        jsonConfig.setStringBeforeRoshanRecoveryRightTime(strBefRoshRecRightTime);
        jsonConfig.setExecChar(eChar);
        jsonConfig.setUsingColon(usColon);
    }
    public Config(){
        this("", "", "", true, "+");
    }

    public static Config initConfig(File configFile) throws IOException {
        Config config;

        if (!configFile.exists()) {
            System.err.println("Main Config file not found! Creating new one...");
            if (!configFile.createNewFile()) {
                System.err.println("Error while creating default config file!");
                System.exit(1);
            }
            // set default settings
            config = new Config("", "", "",
                    true, "+");
            config.writeConfigToFile(configFile);
            System.err.println("Successful creation of default config file!");
        } else {
            config = new Config();
            config.setConfigFromFile(configFile);
            System.out.println("Successful read from config!");
        }

        return config;
    }

    public void setConfigFromFile(File cfgPath) throws IOException {
        FileReader fileConfigReader = new FileReader(cfgPath);
        ObjectMapper mapper = new ObjectMapper();
        jsonConfig = mapper.readValue(fileConfigReader,JsonConfig.class);
    }
    /*
    public void setConfigFromJson(JsonConfig jsonConfig){
        this.stringBeforeAegisExpiredTime = jsonConfig.stringBeforeAegisExpiredTime;
        this.stringBeforeRoshanRecoveryLeftTime = jsonConfig.stringBeforeRoshanRecoveryLeftTime;
        this.stringBeforeRoshanRecoveryRightTime = jsonConfig.stringBeforeRoshanRecoveryRightTime;
        this.usingColon = jsonConfig.usingColon;
        this.execChar = jsonConfig.execChar;
    }

     */

    public void writeConfigToFile(File cfgPath) throws IOException {
        FileWriter fileConfigWriter = new FileWriter(cfgPath);
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(fileConfigWriter,jsonConfig);

        fileConfigWriter.close();
    }

    public JsonConfig getJsonConfig() {
        return jsonConfig;
    }

    public void setJsonConfig(JsonConfig jsonConfig) {
        this.jsonConfig = jsonConfig;
    }
}
