package com.zhmenko.dotatimer.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Hero{
	private boolean silenced;
	private boolean disarmed;
	@JsonProperty("ypos")
	private int yPos;
	private boolean alive;
	@JsonProperty("max_mana")
	private int maxMana;
	private boolean stunned;
	@JsonProperty("respawn_seconds")
	private int respawnSeconds;
	@JsonProperty("mana_percent")
	private int manaPercent;
	private boolean hexed;
	@JsonProperty("buyback_cost")
	private int buybackCost;
	private int id;
	@JsonProperty("buyback_cooldown")
	private int buybackCooldown;
	private boolean muted;
	@JsonProperty("health_percent")
	private int healthPercent;
	private int xpos;
	private boolean smoked;
	@JsonProperty("has_debuff")
	private boolean hasDebuff;
	private int level;
	@JsonProperty("aghanims_scepter")
	private boolean aghanimsScepter;
	private int health;
	private boolean magicimmune;
	@JsonProperty("max_health")
	private int maxHealth;
	private int mana;
	private String name;
	private int xp;
	@JsonProperty("break")
	private boolean breakStatus;
	@JsonProperty("aghanims_shard")
	private boolean aghanimsShard;
	@JsonProperty("talent_1")
	private boolean talent1;
	@JsonProperty("talent_2")
	private boolean talent2;
	@JsonProperty("talent_3")
	private boolean talent3;
	@JsonProperty("talent_4")
	private boolean talent4;
	@JsonProperty("talent_5")
	private boolean talent5;
	@JsonProperty("talent_6")
	private boolean talent6;
	@JsonProperty("talent_7")
	private boolean talent7;
	@JsonProperty("talent_8")
	private boolean talent8;
	@JsonProperty("attributes_level")
	private long attributesLevel;
}