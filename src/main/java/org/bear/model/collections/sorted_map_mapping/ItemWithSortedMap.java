package org.bear.model.collections.sorted_map_mapping;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.Table;

import org.bear.utils.ReverseStringComparator;
import org.hibernate.annotations.SortComparator;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_sorted_map_mapping")
public class ItemWithSortedMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "image_sorted_map_mapping")
	@MapKeyColumn(name = "filename")
	@Column(name = "imagename")
	@SortComparator(ReverseStringComparator.class)
	private SortedMap<String, String> images = new TreeMap<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public SortedMap<String, String> getImages() {
		return images;
	}

	public void setImages(SortedMap<String, String> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithSortedMap that = (ItemWithSortedMap) o;

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
		return "ItemWithSortedMap{" +
				"id=" + id +
				", images=" + images +
				'}';
	}
}
