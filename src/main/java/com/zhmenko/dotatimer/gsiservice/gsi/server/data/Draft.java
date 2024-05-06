package com.zhmenko.dotatimer.gsiservice.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@com.fasterxml.jackson.annotation.JsonFormat(shape = JsonFormat.Shape.ANY)
public class Draft{
	@JsonProperty("activeteam")
	private int activeTeam;
	@JsonProperty("activeteam_time_remaining")
	private int activeTeamTimeRemaining;
	private boolean pick;
	@JsonProperty("dire_bonus_time")
	private int direBonusTime;
	@JsonProperty("radiant_bonus_time")
	private int radiantBonusTime;
	@JsonProperty("team2")
	private TeamDraftState radiantTeamDrafts;
	@JsonProperty("team3")
	private TeamDraftState direTeamDrafts;
}
/*
"draft": {
		"activeteam": 2,
		"pick": false,
		"activeteam_time_remaining": 23,
		"radiant_bonus_time": 130,
		"dire_bonus_time": 130,
		"team2": {
			"home_team": false,
			"pick0_id": 0,
			"pick0_class": "",
			"pick1_id": 0,
			"pick1_class": "",
			"pick2_id": 0,
			"pick2_class": "",
			"pick3_id": 0,
			"pick3_class": "",
			"pick4_id": 0,
			"pick4_class": "",
			"ban0_id": 0,
			"ban0_class": "",
			"ban1_id": 0,
			"ban1_class": "",
			"ban2_id": 0,
			"ban2_class": "",
			"ban3_id": 0,
			"ban3_class": "",
			"ban4_id": 0,
			"ban4_class": "",
			"ban5_id": 0,
			"ban5_class": "",
			"ban6_id": 0,
			"ban6_class": ""
		},
		"team3": {
			"home_team": true,
			"pick0_id": 0,
			"pick0_class": "",
			"pick1_id": 0,
			"pick1_class": "",
			"pick2_id": 0,
			"pick2_class": "",
			"pick3_id": 0,
			"pick3_class": "",
			"pick4_id": 0,
			"pick4_class": "",
			"ban0_id": 0,
			"ban0_class": "",
			"ban1_id": 0,
			"ban1_class": "",
			"ban2_id": 0,
			"ban2_class": "",
			"ban3_id": 0,
			"ban3_class": "",
			"ban4_id": 0,
			"ban4_class": "",
			"ban5_id": 0,
			"ban5_class": "",
			"ban6_id": 0,
			"ban6_class": ""
		}
	}
 */