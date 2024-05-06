package com.zhmenko.dotatimer.gsiservice.main;

import com.github.kwhat.jnativehook.GlobalScreen;
import com.github.kwhat.jnativehook.NativeHookException;
import com.zhmenko.dotatimer.gsiservice.gsi.DotaGSIServerWrapper;
import com.zhmenko.dotatimer.gsiservice.keyboard.GlobalKeyboardListener;
import com.zhmenko.dotatimer.gsiservice.setting.Config;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.net.URISyntaxException;

@Slf4j
public class ApplicationLifecycle {
    public void keyboardListenerInit(Config config, DotaGSIServerWrapper dotaGSIServerWrapper) {
        try {
            GlobalScreen.registerNativeHook();
        } catch (NativeHookException ex) {
            log.error("There was a problem registering the native hook." + ex.getMessage());
            System.exit(1);
        }

        GlobalScreen.addNativeKeyListener(new GlobalKeyboardListener(config, dotaGSIServerWrapper));
    }

    public File getAppDirPath() throws URISyntaxException {
        return new File(MainKeyHookApp.class.getProtectionDomain().getCodeSource()
                .getLocation().toURI().getPath()).getParentFile();
    }
}
