package org.bear.model.collections.set_mapping;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_set_mapping")
public class ItemWithSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(
			name = "image_set_mapping",
			joinColumns = @JoinColumn(name = "item_id")
	)
	@Column(name = "filename", nullable = false)
	private Set<String> images = new HashSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<String> getImages() {
		return images;
	}

	public void setImages(Set<String> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithSet that = (ItemWithSet) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getImages() != null ? getImages().equals(that.getImages()) : that.getImages() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getImages() != null ? getImages().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ItemWithSet{" +
				"id=" + id +
				", images=" + images +
				'}';
	}
}
