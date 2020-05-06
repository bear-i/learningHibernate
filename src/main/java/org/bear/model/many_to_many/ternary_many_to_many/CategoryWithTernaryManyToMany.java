package org.bear.model.many_to_many.ternary_many_to_many;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "category_with_ternary_many_to_many")
public class CategoryWithTernaryManyToMany {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(
			name = "ternary_categorized_item",
			joinColumns = @JoinColumn(name = "category")
	)
	private Set<EmbeddableCategorizedItem> categorizedItems = new HashSet<>();

	public CategoryWithTernaryManyToMany() {
	}

	public CategoryWithTernaryManyToMany(Set<EmbeddableCategorizedItem> categorizedItems) {
		this.categorizedItems = categorizedItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<EmbeddableCategorizedItem> getCategorizedItems() {
		return categorizedItems;
	}

	public void setCategorizedItems(Set<EmbeddableCategorizedItem> categorizedItems) {
		this.categorizedItems = categorizedItems;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		CategoryWithTernaryManyToMany that = (CategoryWithTernaryManyToMany) o;

		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "CategoryWithTernaryManyToMany{" +
				"id=" + id +
				'}';
	}
}
