package com.wj.api.entity;

import lombok.Data;

import java.util.List;

@Data
public class User {
	private String id;
	private String name;
	private List<Role> roleList;
}
