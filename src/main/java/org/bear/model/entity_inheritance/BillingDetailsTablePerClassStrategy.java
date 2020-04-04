package org.bear.model.entity_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

//Table-per-class with unions inheritance strategy example

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(catalog = "sample", schema = "\"public\"", name = "billing_details_table_per_class")
public abstract class BillingDetailsTablePerClassStrategy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

		BillingDetailsTablePerClassStrategy that = (BillingDetailsTablePerClassStrategy) o;

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
		return "BillingDetails01{" +
				"id=" + id +
				", owner='" + owner + '\'' +
				'}';
	}
}
