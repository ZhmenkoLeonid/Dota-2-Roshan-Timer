package com.zhmenko.dotatimer.gsi.server;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.zhmenko.dotatimer.gsi.server.data.DotaGameState;
import lombok.extern.slf4j.Slf4j;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Slf4j
public class DotaGSIHttpHandler extends GSIHttpHandler {
    private ObjectMapper objectMapper;

    @Override
    public void handle(HttpExchange exchange) {
        DotaGameState dotaGameState = getResponse(exchange);
        if (dotaGameState != null) {
            publish(dotaGameState);
        }
    }

    private DotaGameState getResponse(HttpExchange exchange) {
        if (objectMapper == null) objectMapper = new ObjectMapper();
        String requestBody = readRequestBody(exchange);
        try {
            return objectMapper.readValue(requestBody, DotaGameState.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
