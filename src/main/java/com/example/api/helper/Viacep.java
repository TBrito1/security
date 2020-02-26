package com.example.api.helper;

public enum Viacep {

	PATH("http://www.viacep.com.br/ws/"),
	TYPE("/json/");
	
	String property;
	
	private Viacep(String property) {
		this.property = property;
	}

	public String getProperty() {
		return property;
	}

}
