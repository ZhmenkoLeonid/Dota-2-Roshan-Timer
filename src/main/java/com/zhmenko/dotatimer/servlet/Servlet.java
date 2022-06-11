package com.zhmenko.dotatimer.servlet;

import com.zhmenko.dotatimer.setting.Config;
import com.zhmenko.dotatimer.setting.JsonConfig;
import com.zhmenko.dotatimer.keyboard.MessageConverter;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Servlet {
    private BufferedReader in;
    private BufferedWriter out;
    private ServerSocket socket;

    private File fileConfigPath;

    private Config config;
    private MessageConverter messageConverter;
    private int port;

    public Servlet(File fileConfigPath, int port, Config config, MessageConverter messageConverter) {
        this.messageConverter = messageConverter;
        this.fileConfigPath = fileConfigPath;
        this.port = port;
        this.config = config;
    }

    public void connect() throws IOException {
        socket = new ServerSocket(port);
        System.out.println("Started: " + socket);
        try {
            Socket socket = this.socket.accept();
            System.out.println("Connection accepted: " + socket);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            ReadMsg thread = new ReadMsg();
            thread.start();
        } finally {
        }
    }


    private class ReadMsg extends Thread {
        @Override
        public void run() {
            String str;
            try {
                while (true) {
                    str = in.readLine();
                    if (str == null) {
                        throw new NullPointerException();
                    }
                    ObjectMapper mapper = new ObjectMapper();
                    JsonConfig jsonConfig = mapper.readValue(str, JsonConfig.class);
                    config.setJsonConfig(jsonConfig);
                    //update Config
                    messageConverter.setConfig(config);
                    // write config to file
                    config.writeConfigToFile(fileConfigPath);
                    Thread.sleep(1000);
                }
            } catch (Exception e) {
                try {
                    if (!socket.isClosed()) {
                        socket.close();
                        in.close();
                        out.close();
                    }
                } catch (IOException ignored) {
                }
            }

        }
    }
}
