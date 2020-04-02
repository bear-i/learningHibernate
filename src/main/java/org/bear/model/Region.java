package org.bear.model;

public enum Region {
	WESTERN("Western"),
	EASTERN("Eastern");

	private String identifier;

	Region(String identifier) {
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
