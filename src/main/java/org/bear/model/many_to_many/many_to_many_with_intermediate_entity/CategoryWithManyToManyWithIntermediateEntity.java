package org.bear.model.many_to_many.many_to_many_with_intermediate_entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "category_with_many_to_many_with_intermediate_entity")
public class CategoryWithManyToManyWithIntermediateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToMany(mappedBy = "category")
	private Set<CategorizedItem> categorizedItems = new HashSet<>();

	public CategoryWithManyToManyWithIntermediateEntity() {
	}

	public CategoryWithManyToManyWithIntermediateEntity(Set<CategorizedItem> categorizedItems) {
		this.categorizedItems = categorizedItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<CategorizedItem> getCategorizedItems() {
		return categorizedItems;
	}

	public void setCategorizeditems(Set<CategorizedItem> categorizedItems) {
		this.categorizedItems = categorizedItems;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		CategoryWithManyToManyWithIntermediateEntity that = (CategoryWithManyToManyWithIntermediateEntity) o;

		return getId() != null ? getId().equals(that.getId()) : that.getId() == null;
	}

	@Override
	public int hashCode() {
		return getId() != null ? getId().hashCode() : 0;
	}

	@Override
	public String toString() {
		return "CategoryWithManyToManyWithIntermediateEntity{" +
				"id=" + id +
				'}';
	}
}
