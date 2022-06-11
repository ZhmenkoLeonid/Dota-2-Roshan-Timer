package com.zhmenko.dotatimer.servlet;

import com.zhmenko.dotatimer.keyboard.MessageConverter;
import com.zhmenko.dotatimer.setting.Config;

import java.io.File;
import java.io.IOException;

public class ServletThread extends Thread {
    private File fileConfigPath;
    private int port;
    private Config config;
    private MessageConverter messageConverter;

    public ServletThread(File fileConfigPath, int port, Config config,
                         MessageConverter messageConverter) {

        this.messageConverter = messageConverter;
        this.fileConfigPath = fileConfigPath;
        this.port = port;
        this.config = config;
    }

    @Override
    public void run() {
        // запускаем прослушку сокета
        Servlet serv = new Servlet(fileConfigPath, port, config, messageConverter);
        while (true) {
            try {
                serv.connect();
                serv.wait();
            } catch (IOException | InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
