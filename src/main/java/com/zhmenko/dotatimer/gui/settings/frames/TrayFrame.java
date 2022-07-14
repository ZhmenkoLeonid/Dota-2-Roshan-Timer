package com.zhmenko.dotatimer.gui.settings.frames;

import com.zhmenko.dotatimer.setting.Config;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Slf4j
public class TrayFrame {
    private final String APPLICATION_NAME = "Dota Timer";
    private final String ICON_PATH = "/images/WhiteDotaIcon.png";
    private final Config config;
    private SettingsFrame settingsFrame;
    @SneakyThrows
    public TrayFrame(Config config) throws IOException {
        this.config = config;
        if(!SystemTray.isSupported() ) {
            return;
        }

        PopupMenu trayMenu = new PopupMenu();
        MenuItem settingsItem = new MenuItem("Settings");
        settingsItem.addActionListener(e -> {
            log.info(this.config.toString());
            settingsFrame = new SettingsFrame(this.config);
            settingsFrame.setVisible(true);
        });
        MenuItem exitItem = new MenuItem("Exit");
        exitItem.addActionListener(e -> System.exit(0));

        trayMenu.add(settingsItem);
        trayMenu.addSeparator();
        trayMenu.add(exitItem);

        URL in = getClass().getResource(ICON_PATH);
        BufferedImage bufferedImage = ImageIO.read(in);

        TrayIcon trayIcon = new TrayIcon(bufferedImage, APPLICATION_NAME, trayMenu);
        trayIcon.setImageAutoSize(true);

        SystemTray tray = SystemTray.getSystemTray();
        try {
            tray.add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void setTrayIcon() throws IOException {

/*
        trayIcon.displayMessage(APPLICATION_NAME, "Application started!",
                TrayIcon.MessageType.INFO);*/
    }
}
