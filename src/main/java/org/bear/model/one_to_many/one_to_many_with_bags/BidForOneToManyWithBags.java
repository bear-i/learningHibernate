package org.bear.model.one_to_many.one_to_many_with_bags;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "bid_for_one_to_many_with_bags")
public class BidForOneToManyWithBags {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "item_id", nullable = false)
	private ItemWithOneToManyWithBags item;

	public BidForOneToManyWithBags() {
	}

	public BidForOneToManyWithBags(ItemWithOneToManyWithBags item) {
		this.item = item;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ItemWithOneToManyWithBags getItem() {
		return item;
	}

	public void setItem(ItemWithOneToManyWithBags item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		BidForOneToManyWithBags that = (BidForOneToManyWithBags) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getItem() != null ? getItem().equals(that.getItem()) : that.getItem() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getItem() != null ? getItem().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BidForOneToManyWithBags{" +
				"id=" + id +
				", item=" + item.getId() +
				'}';
	}
}
