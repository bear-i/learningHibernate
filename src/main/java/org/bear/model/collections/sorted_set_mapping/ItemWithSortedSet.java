package org.bear.model.collections.sorted_set_mapping;

import java.util.SortedSet;
import java.util.TreeSet;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.SortNatural;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_sorted_set_mapping")
public class ItemWithSortedSet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "image_sorted_set_mapping")
	@Column(name = "filename", nullable = false)
	@SortNatural
	private SortedSet<String> images = new TreeSet<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SortedSet<String> getImages() {
		return images;
	}

	public void setImages(SortedSet<String> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithSortedSet that = (ItemWithSortedSet) o;

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
		return "ItemWithSortedSet{" +
				"id=" + id +
				", images=" + images +
				'}';
	}
}
