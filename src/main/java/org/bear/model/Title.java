package org.bear.model;

public enum Title {
	VP_SALES("VP Sales"),
	SALES_REP("Sales Rep"),
	SALES_MGR("Sales Mgr");

	String identifier;

	Title(String identifier) {
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
