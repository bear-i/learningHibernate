package org.bear.model.one_to_many.one_to_many_with_join_table;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "user_with_one_to_many_with_join_table")
public class UserWithOneToManyWithJoinTable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "buyer")
	private Set<ItemWithOneToManyWithJoinTable> items = new HashSet<>();

	public UserWithOneToManyWithJoinTable() {
	}

	public UserWithOneToManyWithJoinTable(Set<ItemWithOneToManyWithJoinTable> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ItemWithOneToManyWithJoinTable> getItems() {
		return items;
	}

	public void setItems(Set<ItemWithOneToManyWithJoinTable> items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		UserWithOneToManyWithJoinTable that = (UserWithOneToManyWithJoinTable) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getItems() != null ? getItems().equals(that.getItems()) : that.getItems() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getItems() != null ? getItems().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UserWithOneToManyWithJoinTable{" +
				"id=" + id +
				", items=" + items +
				'}';
	}
}
