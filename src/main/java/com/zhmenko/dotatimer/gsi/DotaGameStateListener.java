package com.zhmenko.dotatimer.gsi;

import com.github.mrbean355.dota2.GameState;
import com.github.mrbean355.dota2.server.GameStateListener;
import org.jetbrains.annotations.NotNull;

import java.util.Observable;

public class DotaGameStateListener extends Observable implements GameStateListener {
    @Override
    public void invoke(@NotNull GameState gameState) {
        setChanged();
        notifyObservers(gameState.getMap().getClockTime());
    }
}