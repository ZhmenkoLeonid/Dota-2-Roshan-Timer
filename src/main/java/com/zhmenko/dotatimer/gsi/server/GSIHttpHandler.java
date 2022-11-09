package com.zhmenko.dotatimer.gsi.server;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.zhmenko.dotatimer.util.subscription.Broker;

import java.io.BufferedReader;
import java.io.InputStreamReader;

abstract public class GSIHttpHandler extends Broker implements HttpHandler {
    protected String readRequestBody(HttpExchange exchange) {
        StringBuilder request = new StringBuilder();
        //StringBuilder requestLines = new StringBuilder();
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(exchange.getRequestBody()));
            String inl;
            while ((inl = in.readLine()) != null) {
                request.append(inl);
                //requestLines.append(inl).append(System.lineSeparator());
            }
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //System.out.println(requestLines.toString());
        return request.toString();
    }
}