package com.zhmenko.dotatimer.gsi.server.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ItemSlot {
	@JsonProperty("can_cast")
	private boolean canCast;
	private int charges;
	private int purchaser;
	private String name;
	private int cooldown;
	private boolean passive;
}