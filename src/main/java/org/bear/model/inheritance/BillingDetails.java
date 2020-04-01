package org.bear.model.inheritance;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class BillingDetails {

	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
