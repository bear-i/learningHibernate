package org.bear.model.many_to_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "category_with_many_to_many")
public class CategoryWithManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "category_item",
			joinColumns = @JoinColumn(name = "category_id", nullable = false),
			inverseJoinColumns = @JoinColumn(name = "item_id", nullable = false)
	)
	private Set<ItemWithManyToMany> items = new HashSet<>();

	public CategoryWithManyToMany() {

	}

	public CategoryWithManyToMany(Set<ItemWithManyToMany> items) {
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<ItemWithManyToMany> getItems() {
		return items;
	}

	public void setItems(Set<ItemWithManyToMany> items) {
		this.items = items;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		CategoryWithManyToMany that = (CategoryWithManyToMany) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getItems() != null ? getItems().equals(that.getItems()) : that.getItems() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "CategoryWithManyToMany{" +
				"id=" + id;
	}
}
