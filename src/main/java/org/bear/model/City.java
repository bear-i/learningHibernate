package org.bear.model;

public enum City {
	DENVER("Denver"),
	NEW_YORK("New York"),
	LOS_ANGELES("Los Angeles"),
	ATLANTA("Atlanta"),
	CHICAGO("Chicago");

	private String identifier;

	City(String identifier) {
		this.identifier = identifier;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	@Override
	public String toString() {
		return identifier;
	}
}
