package com.zhmenko.dotatimer.main;

import com.zhmenko.dotatimer.gsi.DotaGSIServerWrapper;
import com.zhmenko.dotatimer.gui.frames.TrayFrame;
import com.zhmenko.dotatimer.setting.Config;

import java.io.File;

public class MainKeyHookApp {
    private static final int GSI_PORT = 47471;

    public static void main(String[] args) throws Exception {
        ApplicationLifecycle applicationLifecycle = new ApplicationLifecycle();
        File appDir = applicationLifecycle.getAppDirPath();
        File configFile = new File(appDir + "\\config.cfg");

        // define config file
        Config config = new Config(configFile);
        // init tray icon
        new TrayFrame(config);
        // init gsi server listener
        DotaGSIServerWrapper dotaGsiServer = new DotaGSIServerWrapper(GSI_PORT);
        // init global keyboard listener
        applicationLifecycle.keyboardListenerInit(config, dotaGsiServer);
    }
}
