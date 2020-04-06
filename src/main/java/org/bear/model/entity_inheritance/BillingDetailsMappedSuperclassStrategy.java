package org.bear.model.entity_inheritance;

import javax.persistence.MappedSuperclass;

//Mapped superclass inheritance strategy example

@MappedSuperclass
public abstract class BillingDetailsMappedSuperclassStrategy {

	private String owner;

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

}