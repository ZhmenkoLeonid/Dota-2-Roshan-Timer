package com.zhmenko.dotatimer.gsi.server.data;

import lombok.Data;

@Data
public class Provider{
	private int appid;
	private String name;
	private int version;
	private int timestamp;
}
/*
	"provider": {
		"name": "Dota 2",
		"appid": 570,
		"version": 47,
		"timestamp": 1663427328
	}
 */