package org.bear.model.entity_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

//Joined-tables inheritance strategy example

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BillingDetailsJoinedTablesStrategy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "owner", nullable = false)
	private String owner;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		BillingDetailsSingleTableStrategy that = (BillingDetailsSingleTableStrategy) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getOwner() != null ? getOwner().equals(that.getOwner()) : that.getOwner() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getOwner() != null ? getOwner().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BillingDetails02{" +
				"id=" + id +
				", owner='" + owner + '\'' +
				'}';
	}
}
