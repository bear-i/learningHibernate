package org.bear.model.inheritance;

import javax.persistence.MappedSuperclass;

//Mapped superclass inheritance strategy example

@MappedSuperclass
public abstract class BillingDetails00 {

	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}
