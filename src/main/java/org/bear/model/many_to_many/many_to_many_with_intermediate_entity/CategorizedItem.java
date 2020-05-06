package org.bear.model.many_to_many.many_to_many_with_intermediate_entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Immutable;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "categorized_item")
@Immutable
public class CategorizedItem {

	@EmbeddedId
	private Id id = new Id();

	@Column(name = "added_by", updatable = false)
	@NotNull
	private String addedBy;

	@Column(name = "added_on", updatable = false)
	@NotNull
	private Date addedOn = new Date();

	@ManyToOne
	@JoinColumn(name = "category_id", insertable = false, updatable = false)
	private CategoryWithManyToManyWithIntermediateEntity category;

	@ManyToOne
	@JoinColumn(name = "item_id", insertable = false, updatable = false)
	private ItemWithManyToManyWithIntermediateEntity item;

	public CategorizedItem(@NotNull String addedBy, CategoryWithManyToManyWithIntermediateEntity category, ItemWithManyToManyWithIntermediateEntity item) {
		this.addedBy = addedBy;
		this.category = category;
		this.item = item;

		this.id.categoryId = category.getId();
		this.id.itemId = item.getId();

		category.getCategorizedItems().add(this);
		item.getCategorizedItems().add(this);
	}

	@Embeddable
	public static class Id implements Serializable {

		@Column(name = "category_id")
		private Long categoryId;

		@Column(name = "item_id")
		private Long itemId;

		public Id() {
		}

		public Id(Long categoryId, Long itemId) {
			this.categoryId = categoryId;
			this.itemId = itemId;
		}

		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;

			Id id = (Id) o;

			if(categoryId != null ? !categoryId.equals(id.categoryId) : id.categoryId != null) return false;
			return itemId != null ? itemId.equals(id.itemId) : id.itemId == null;
		}

		@Override
		public int hashCode() {
			int result = categoryId != null ? categoryId.hashCode() : 0;
			result = 31 * result + (itemId != null ? itemId.hashCode() : 0);
			return result;
		}
	}
}
