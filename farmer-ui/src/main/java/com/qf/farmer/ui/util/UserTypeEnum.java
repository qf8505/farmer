package com.qf.farmer.ui.util;

public enum UserTypeEnum {
	
	USER("普通用户","user"),
	FARMER("农场主","farmer"),
	SUPPLIER("供应商","supplier");
	
	private String name;
	private String value;

	UserTypeEnum(String name, String value) {
		this.name=name;
		this.value=value;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
	
}
