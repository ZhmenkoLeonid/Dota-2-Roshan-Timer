package com.zhmenko.dotatimer.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class TeamDraftState {
	@JsonProperty("home_team")
	private boolean homeTeam;
	@JsonProperty("pick0_id")
	private int pick0Id;
	@JsonProperty("pick0_class")
	private String pick0Class;
	@JsonProperty("pick1_id")
	private int pick1Id;
	@JsonProperty("pick1_class")
	private String pick1Class;
	@JsonProperty("pick2_id")
	private int pick2Id;
	@JsonProperty("pick2_class")
	private String pick2Class;
	@JsonProperty("pick3_id")
	private int pick3Id;
	@JsonProperty("pick3_class")
	private String pick3Class;
	@JsonProperty("pick4_id")
	private int pick4Id;
	@JsonProperty("pick4_class")
	private String pick4Class;
	@JsonProperty("ban0_id")
	private int ban0Id;
	@JsonProperty("ban0_class")
	private String ban0Class;
	@JsonProperty("ban1_id")
	private int ban1Id;
	@JsonProperty("ban1_class")
	private String ban1Class;
	@JsonProperty("ban2_id")
	private int ban2Id;
	@JsonProperty("ban2_class")
	private String ban2Class;
	@JsonProperty("ban3_id")
	private int ban3Id;
	@JsonProperty("ban3_class")
	private String ban3Class;
	@JsonProperty("ban4_id")
	private int ban4Id;
	@JsonProperty("ban4_class")
	private String ban4Class;
	@JsonProperty("ban5_id")
	private int ban5Id;
	@JsonProperty("ban5_class")
	private String ban5Class;
	@JsonProperty("ban6_id")
	private int ban6Id;
	@JsonProperty("ban6_class")
	private String ban6Class;
}
/*
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
	},
 */