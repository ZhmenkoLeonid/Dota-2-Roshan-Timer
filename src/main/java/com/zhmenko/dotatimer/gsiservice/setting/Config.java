package com.zhmenko.dotatimer.gsiservice.setting;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

@Slf4j
@Data
public class Config {
    private ConfigProperties configProperties;
    private File configFile;

    private ObjectMapper mapper;

    public Config(File configFile) throws IOException {
        this.configFile = Objects.requireNonNull(configFile);
        if (!configFile.exists()) {
            log.info("Main Config file not found! Creating new one...");
            configFile.createNewFile();
            // set default settings
            this.configProperties = new ConfigProperties("", "", "", true, '+');
            writeConfigToFile();
            log.info("Successful creation of default config file!");
        } else {
            readConfigFromFile();
            log.info("Successful read from config!");
        }
    }

    public void readConfigFromFile() throws IOException {
        if (mapper == null) mapper = new ObjectMapper();
        configProperties = mapper.readValue(configFile, ConfigProperties.class);
    }

    public void writeConfigToFile() throws IOException {
        if (mapper == null) mapper = new ObjectMapper();
        mapper.writeValue(configFile, configProperties);
    }
}
