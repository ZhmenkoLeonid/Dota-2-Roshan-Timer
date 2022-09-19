package com.zhmenko.dotatimer.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Ability {
	private String name;
	@JsonProperty("can_cast")
	private boolean canCast;
	@JsonProperty("ability_active")
	private boolean abilityActive;
	private int level;
	private boolean ultimate;
	private int cooldown;
	private boolean passive;
	private int charges;
	@JsonProperty("max_charges")
	private int maxCharges;
	@JsonProperty("charge_cooldown")
	private int chargeCooldown;
}

/*
{
			"name": "seasonal_ti11_balloon",
			"level": 1,
			"can_cast": false,
			"passive": false,
			"ability_active": true,
			"cooldown": 0,
			"ultimate": false,
			"charges": 0,
			"max_charges": 0,
			"charge_cooldown": 0
		}
 */