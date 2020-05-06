package org.bear.model.many_to_many.ternary_many_to_many;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_with_ternary_many_to_many")
public class ItemWithTernaryManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	public ItemWithTernaryManyToMany() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithTernaryManyToMany that = (ItemWithTernaryManyToMany) o;

		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "ItemWithTernaryManyToMany{" +
				"id=" + id +
				'}';
	}
}
