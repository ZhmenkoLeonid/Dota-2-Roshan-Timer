package com.zhmenko.dotatimer.gsi.server.data;

import lombok.Data;
@Data
public class DotaGameState {
	private java.util.Map<String, Ability> abilities;
	private Provider provider;
	private Hero hero;
	private Map map;
	private java.util.Map<String,ItemSlot> items;
	private Player player;
	private Buildings buildings;
	private java.util.Map<String, Long> wearables;
	private Draft draft;
}