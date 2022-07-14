package com.zhmenko.dotatimer.main;

import com.zhmenko.dotatimer.gsi.DotaGSI;
import com.zhmenko.dotatimer.gui.settings.frames.TrayFrame;
/*import com.zhmenko.dotatimer.servlet.ServletThread;*/
import com.zhmenko.dotatimer.setting.Config;
import com.zhmenko.dotatimer.keyboard.MessageConverter;

import java.io.*;

public class MainKeyHookApp {
    private static final int GSI_PORT = 47471;

    public static void main(String[] args) throws Exception {
        ApplicationLifecycle applicationLifecycle = new ApplicationLifecycle();

        File appDir = applicationLifecycle.getAppDirPath();
        File configFile = new File(appDir + "\\config.cfg");

        // define config file
        Config config = new Config(configFile);
        // init GSI server listener
        DotaGSI dotaGSI = new DotaGSI(GSI_PORT);
        // init hook process
        applicationLifecycle.keyboardListenerInit(config, dotaGSI);
        // init tray icon
        new TrayFrame(config);
    }
}
