package com.zhmenko.dotatimer.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Player{
	private int kills;
	@JsonProperty("gold_from_hero_kills")
	private int goldFromHeroKills;
	@JsonProperty("gold_reliable")
	private int goldReliable;
	private String activity;
	private int gpm;
	@JsonProperty("kill_streak")
	private int killStreak;
	@JsonProperty("gold_from_income")
	private int goldFromIncome;
	@JsonProperty("gold_from_shared")
	private int goldFromShared;
	private int denies;
	@JsonProperty("team_name")
	private String teamName;
	private String steamid;
	private String accountid;
	@JsonProperty("kill_list")
	private java.util.Map<String, String> killList;
	private int gold;
	@JsonProperty("last_hits")
	private int lastHits;
	@JsonProperty("gold_unreliable")
	private int goldUnreliable;
	@JsonProperty("commands_issued")
	private int commandsIssued;
	private int xpm;
	private int assists;
	private String name;
	@JsonProperty("gold_from_creep_kills")
	private int goldFromCreepKills;
	private int deaths;
}

/* example
* 	"player": {
		"steamid": "11111111111111111",
		"name": "EX_NAME",
		"activity": "playing",
		"kills": 0,
		"deaths": 0,
		"assists": 0,
		"last_hits": 0,
		"denies": 0,
		"kill_streak": 0,
		"commands_issued": 0,
		"kill_list": {

		},
		"team_name": "radiant",
		"gold": 894,
		"gold_reliable": 294,
		"gold_unreliable": 600,
		"gold_from_hero_kills": 0,
		"gold_from_creep_kills": 0,
		"gold_from_income": 294,
		"gold_from_shared": 0,
		"gpm": 90,
		"xpm": 3
	},
* */