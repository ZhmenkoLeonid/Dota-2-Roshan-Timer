package com.zhmenko.dotatimer.gsi.server.data;

import lombok.Data;

@Data
public class Buildings{
	private java.util.Map<String, Building> dire;
	private java.util.Map<String, Building> radiant;
}