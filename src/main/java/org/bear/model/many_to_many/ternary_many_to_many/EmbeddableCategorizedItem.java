package org.bear.model.many_to_many.ternary_many_to_many;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Embeddable
public class EmbeddableCategorizedItem {

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false, updatable = false)
	private ItemWithTernaryManyToMany item;

	@ManyToOne
	@NotNull
	@JoinColumn(name = "\"user\"", updatable = false)
	private UserWithTernaryManytoMany addedBy;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(updatable = false)
	@NotNull
	private Date addedOn = new Date();

	public EmbeddableCategorizedItem() {
	}

	public EmbeddableCategorizedItem(ItemWithTernaryManyToMany item, @NotNull UserWithTernaryManytoMany addedBy) {
		this.item = item;
		this.addedBy = addedBy;
	}

	public ItemWithTernaryManyToMany getItem() {
		return item;
	}

	public void setItem(ItemWithTernaryManyToMany item) {
		this.item = item;
	}

	public UserWithTernaryManytoMany getAddedBy() {
		return addedBy;
	}

	public void setAddedBy(UserWithTernaryManytoMany addedBy) {
		this.addedBy = addedBy;
	}

	public Date getAddedOn() {
		return addedOn;
	}

	public void setAddedOn(Date addedOn) {
		this.addedOn = addedOn;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		EmbeddableCategorizedItem that = (EmbeddableCategorizedItem) o;

		if(getItem() != null ? !getItem().equals(that.getItem()) : that.getItem() != null) return false;
		if(getAddedBy() != null ? !getAddedBy().equals(that.getAddedBy()) : that.getAddedBy() != null) return false;
		return getAddedOn() != null ? getAddedOn().equals(that.getAddedOn()) : that.getAddedOn() == null;
	}

	@Override
	public int hashCode() {
		int result = getItem() != null ? getItem().hashCode() : 0;
		result = 31 * result + (getAddedBy() != null ? getAddedBy().hashCode() : 0);
		result = 31 * result + (getAddedOn() != null ? getAddedOn().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "EmbeddableCategorizedItem{" +
				"item=" + item +
				", addedBy=" + addedBy +
				", addedOn=" + addedOn +
				'}';
	}
}
