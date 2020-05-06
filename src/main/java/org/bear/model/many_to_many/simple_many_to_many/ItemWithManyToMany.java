package org.bear.model.many_to_many.simple_many_to_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_with_many_to_many")
public class ItemWithManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(mappedBy = "items")
	private Set<CategoryWithManyToMany> categories = new HashSet<>();

	public ItemWithManyToMany() {
	}

	public ItemWithManyToMany(Set<CategoryWithManyToMany> categories) {
		this.categories = categories;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CategoryWithManyToMany> getCategories() {
		return categories;
	}

	public void setCategories(Set<CategoryWithManyToMany> categories) {
		this.categories = categories;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithManyToMany that = (ItemWithManyToMany) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getCategories() != null ? getCategories().equals(that.getCategories()) : that.getCategories() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "ItemWithManyToMany{" +
				"id=" + id;
	}
}
