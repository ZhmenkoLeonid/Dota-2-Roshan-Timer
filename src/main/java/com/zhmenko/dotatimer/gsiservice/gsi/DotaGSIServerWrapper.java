package com.zhmenko.dotatimer.gsiservice.gsi;

import com.zhmenko.dotatimer.gsiservice.gsi.server.DotaGSIHttpHandler;
import com.zhmenko.dotatimer.gsiservice.gsi.server.GSIServer;
import com.zhmenko.dotatimer.gsiservice.gsi.server.data.DotaGameState;
import com.zhmenko.dotatimer.gsiservice.subscription.Subscription;
import lombok.Getter;
import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

@Slf4j
public class DotaGSIServerWrapper  {
    @Getter
    private long currentClockTime;
    private final GSIServer gsiServer;

    public DotaGSIServerWrapper(int gsiPort) throws IOException {
        this(gsiPort, new DotaGSIHttpHandler());
    }

    public DotaGSIServerWrapper(int gsiPort, DotaGSIHttpHandler dotaHttpHandler) throws IOException {
        this.gsiServer = new GSIServer(gsiPort, dotaHttpHandler);
        gsiServer.addSubscriber(this);
    }

    @Subscription
    public void onGameState(@NotNull DotaGameState gameState) {
        if (gameState.getMap() != null) {
            long clockTime = gameState.getMap().getClockTime();
            log.info("time updated: old=" + currentClockTime + " new=" + clockTime);
            this.currentClockTime = clockTime;
        } else log.error("Failed to update. Game state Map info is null!");
    }
}
