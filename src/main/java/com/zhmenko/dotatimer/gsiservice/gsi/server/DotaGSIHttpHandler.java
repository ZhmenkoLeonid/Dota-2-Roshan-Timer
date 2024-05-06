package com.zhmenko.dotatimer.gsiservice.gsi.server;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.net.httpserver.HttpExchange;
import com.zhmenko.dotatimer.gsiservice.gsi.server.data.DotaGameState;
import lombok.extern.slf4j.Slf4j;

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
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        }
        String requestBody = readRequestBody(exchange);
        // full json
        //log.info(requestBody);
        try {
            return objectMapper.readValue(requestBody, DotaGameState.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
