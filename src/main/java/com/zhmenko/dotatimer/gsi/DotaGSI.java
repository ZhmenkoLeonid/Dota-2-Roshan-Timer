package com.zhmenko.dotatimer.gsi;

import com.github.mrbean355.dota2.server.GameStateServer;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.Observable;
import java.util.Observer;

@Slf4j
public class DotaGSI implements Observer {
    @Getter
    private long currentClockTime;
    private final GameStateServer gameStateServer;

    public DotaGSI(int gsiPort) {
        DotaGameStateListener gameStateListener = new DotaGameStateListener();
        gameStateListener.addObserver(this);
        this.gameStateServer = new GameStateServer(gsiPort, gameStateListener);
        this.gameStateServer.start(false);
    }

    @Override
    public void update(Observable o, Object arg) {
        log.info("time updated: old=" + currentClockTime + " new=" + arg);
        this.currentClockTime = (long) arg;
    }
}
