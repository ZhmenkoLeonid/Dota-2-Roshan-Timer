package com.zhmenko.dotatimer.main;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.zhmenko.dotatimer.fileflag.FlagThread;
import com.zhmenko.dotatimer.gsi.DotaGSI;
import com.zhmenko.dotatimer.keyboard.GlobalKeyboardListener;
import com.zhmenko.dotatimer.keyboard.MessageConverter;
import lombok.extern.slf4j.Slf4j;

import java.awt.*;
import java.io.File;
import java.net.URISyntaxException;

@Slf4j
public class ApplicationLifecycle {
    public void flagCheckThreadInit(File flagFile, long frequency) {
        Thread flagCheckThread = new FlagThread(flagFile, frequency);
        flagCheckThread.start();
    }

    public void keyboardListenerInit(MessageConverter messageConverter, DotaGSI dotaGSI) throws AWTException {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            log.error("There was a problem registering the native hook." + ex.getMessage());

            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyboardListener(messageConverter,dotaGSI));
    }

    public File getAppDirPath() throws URISyntaxException {
        return new File(MainKeyHookApp.class.getProtectionDomain().getCodeSource()
                .getLocation().toURI().getPath()).getParentFile();
    }
}
