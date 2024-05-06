package com.zhmenko.dotatimer.gsiservice.gsi.server;

import com.sun.net.httpserver.HttpServer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;


@Slf4j
public class GSIServer {
    private final HttpServer server;
    private final GSIHttpHandler serverHttpHandler;
    public GSIServer(int port, GSIHttpHandler serverHttpHandler) throws IOException {
        server = HttpServer.create(new InetSocketAddress(port), 0);
        this.serverHttpHandler = serverHttpHandler;
        server.createContext("/", serverHttpHandler);
        server.setExecutor(Executors.newCachedThreadPool());
        server.start();
        log.debug("Server successfully started on port " + port);
    }
    public GSIServer(int port) throws IOException {
        this(port, new DotaGSIHttpHandler());
    }

    public void addSubscriber(Object gsiSubscriber) {
        serverHttpHandler.addSubscriber(gsiSubscriber);
    }
}
