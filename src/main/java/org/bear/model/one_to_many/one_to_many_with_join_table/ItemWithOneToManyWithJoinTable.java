package org.bear.model.one_to_many.one_to_many_with_join_table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_with_one_to_many_with_join_table")
public class ItemWithOneToManyWithJoinTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinTable(
			name = "item_buyer",
			joinColumns = @JoinColumn(name = "item_id"),
			inverseJoinColumns = @JoinColumn(name = "buyer_id")
	)
	private UserWithOneToManyWithJoinTable buyer;

	public ItemWithOneToManyWithJoinTable() {
	}

	public ItemWithOneToManyWithJoinTable(UserWithOneToManyWithJoinTable buyer) {
		this.buyer = buyer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public UserWithOneToManyWithJoinTable getBuyer() {
		return buyer;
	}

	public void setBuyer(UserWithOneToManyWithJoinTable buyer) {
		this.buyer = buyer;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithOneToManyWithJoinTable that = (ItemWithOneToManyWithJoinTable) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getBuyer() != null ? getBuyer().equals(that.getBuyer()) : that.getBuyer() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getBuyer() != null ? getBuyer().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ItemWithOneToManyWithJoinTable{" +
				"id=" + id +
				", buyer=" + buyer.getId() +
				'}';
	}
}
