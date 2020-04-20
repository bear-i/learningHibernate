package org.bear.model.one_to_many.one_to_many_with_list;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OrderColumn;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_with_one_to_many_with_list")
public class ItemWithOneToManyWithList {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany
	@JoinColumn(
			name = "item_id",
			nullable = false
	)
	@OrderColumn(
			name = "bid_position",
			nullable = false
	)
	private List<BidForOneToManyWithList> bids = new ArrayList<>();

	public ItemWithOneToManyWithList() {
	}

	public ItemWithOneToManyWithList(List<BidForOneToManyWithList> bids) {
		this.bids = bids;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<BidForOneToManyWithList> getBids() {
		return bids;
	}

	public void setBids(List<BidForOneToManyWithList> bids) {
		this.bids = bids;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithOneToManyWithList that = (ItemWithOneToManyWithList) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getBids() != null ? getBids().equals(that.getBids()) : that.getBids() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getBids() != null ? getBids().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ItemWithOneToManyWithList{" +
				"id=" + id +
				", bids=" + bids +
				'}';
	}
}
