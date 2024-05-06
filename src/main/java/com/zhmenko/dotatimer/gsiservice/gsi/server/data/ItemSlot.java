package com.zhmenko.dotatimer.gsiservice.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSlot {

	@JsonProperty("can_cast")
	private boolean canCast;
	@JsonProperty("item_charges")
	private int itemCharges;
	private int charges;
	private int purchaser;
	private String name;
	private int cooldown;
	private boolean passive;
	@JsonProperty("item_level")
	private int itemLevel;
}