package org.bear.model.one_to_one.join_table;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "item_with_join_table")
public class ItemWithJoinTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "item_name")
	private String itemName;

	public ItemWithJoinTable() {
	}

	public ItemWithJoinTable(String itemName) {
		this.itemName = itemName;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithJoinTable that = (ItemWithJoinTable) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getItemName() != null ? getItemName().equals(that.getItemName()) : that.getItemName() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getItemName() != null ? getItemName().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ItemWithJoinTable{" +
				"id=" + id +
				", itemName='" + itemName + '\'' +
				'}';
	}
}
