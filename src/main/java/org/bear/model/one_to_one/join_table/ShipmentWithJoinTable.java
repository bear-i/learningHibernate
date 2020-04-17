package org.bear.model.one_to_one.join_table;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "shipment_with_join_table")
public class ShipmentWithJoinTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "item_shipment",
			joinColumns = @JoinColumn(name = "shipment_id"),
			inverseJoinColumns = @JoinColumn(name = "Item_id", unique = true)
	)
	private ItemWithJoinTable item;

	public ShipmentWithJoinTable() {
	}

	public ShipmentWithJoinTable(ItemWithJoinTable item) {
		this.item = item;
	}

	public ItemWithJoinTable getItem() {
		return item;
	}

	public void setItem(ItemWithJoinTable item) {
		this.item = item;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ShipmentWithJoinTable that = (ShipmentWithJoinTable) o;

		return getItem() != null ? getItem().equals(that.getItem()) : that.getItem() == null;
	}

	@Override
	public int hashCode() {
		return getItem() != null ? getItem().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "ShipmentWithJoinTable{" +
				"item=" + item +
				'}';
	}
}
