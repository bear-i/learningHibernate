package org.bear.model.embeddable_collections.embeddable_map;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_full_embeddable_map_mapping")
public class ItemWithFullEmbeddableMap {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "image_full_embeddable_map_mapping")
	private Map<Filename, ImageForEmbeddableMap> images = new HashMap<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Map<Filename, ImageForEmbeddableMap> getImages() {
		return images;
	}

	public void setImages(Map<Filename, ImageForEmbeddableMap> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithFullEmbeddableMap that = (ItemWithFullEmbeddableMap) o;

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
		return "ItemWithFullEmbeddableMap{" +
				"id=" + id +
				", images=" + images +
				'}';
	}
}
