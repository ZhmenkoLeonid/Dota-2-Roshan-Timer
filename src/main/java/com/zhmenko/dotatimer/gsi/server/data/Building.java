package com.zhmenko.dotatimer.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Building {
    @JsonProperty("max_health")
    private int maxHealth;
    private int health;
}
