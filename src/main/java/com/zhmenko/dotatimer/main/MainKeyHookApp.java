package com.zhmenko.dotatimer.main;

import com.zhmenko.dotatimer.gsi.DotaGSI;
import com.zhmenko.dotatimer.servlet.ServletThread;
import com.zhmenko.dotatimer.setting.Config;
import com.zhmenko.dotatimer.keyboard.MessageConverter;

import java.io.*;

public class MainKeyHookApp {
    private static final int port = 1455;

    public static void main(String[] args) throws Exception {
        ApplicationLifecycle applicationLifecycle = new ApplicationLifecycle();
/*        System.setErr(new PrintStream(new File("log.txt")));*/

        File appDir = applicationLifecycle.getAppDirPath();
        File flagFile = new File(appDir + "\\dotaTimer.flag");
        File configFile = new File(appDir + "\\config.cfg");

        // define config file
        Config config = Config.initConfig(configFile);

        MessageConverter messageConverter = new MessageConverter(config);

        //init GSI server listener
        DotaGSI dotaGSI = new DotaGSI(47471);

        // init flag file check
        applicationLifecycle.flagCheckThreadInit(flagFile, 1000);

        // init hook process
        applicationLifecycle.keyboardListenerInit(messageConverter, dotaGSI);

        //TODO
        ServletThread servletThread = new ServletThread(configFile, port, config, messageConverter);
        servletThread.start();
    }
}

