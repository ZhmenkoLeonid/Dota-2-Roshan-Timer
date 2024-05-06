package com.zhmenko.dotatimer.gsiservice.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Map {
	@JsonProperty("win_team")
	private String winTeam;
	private boolean paused;
	@JsonProperty("clock_time")
	private int clockTime;
	private String customgamename;
	@JsonProperty("ward_purchase_cooldown")
	private int wardPurchaseCooldown;
	@JsonProperty("nightstalker_night")
	private boolean nightstalkerNight;
	@JsonProperty("game_state")
	private String gameState;
	@JsonProperty("game_time")
	private int gameTime;
	@JsonProperty("dire_score")
	private int direScore;
	private String name;
	@JsonProperty("radiant_score")
	private int radiantScore;
	private boolean daytime;
	private String matchid;
	@JsonProperty("roshan_state")
	private String roshanState;
}
/*
*{
,
	"map": {
		"name": "start",
		"matchid": "6762826218",
		"game_time": 331,
		"clock_time": 195,
		"daytime": true,
		"nightstalker_night": false,
		"radiant_score": 0,
		"dire_score": 0,
		"game_state": "DOTA_GAMERULES_STATE_GAME_IN_PROGRESS",
		"paused": false,
		"win_team": "none",
		"customgamename": "",
		"ward_purchase_cooldown": 0
	},



}
* */