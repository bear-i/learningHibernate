package org.bear.model.embeddable_collections.embeddable_bag;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.Type;

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "item_embeddable_bag_mapping")
public class ItemWithEmbeddableBag {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ElementCollection
	@CollectionTable(name = "images_embeddable_bag_mapping",
			joinColumns = @JoinColumn(name = "item_id"))
	@SequenceGenerator(name = "embeddable_image_gen", sequenceName = "embeddable_image_seq", allocationSize = 1)
	@CollectionId(columns = @Column(name = "image_id"),
			type = @Type(type = "long"),
			generator = "embeddable_image_gen")
	private Collection<ImageForEmbeddableBag> images = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Collection<ImageForEmbeddableBag> getImages() {
		return images;
	}

	public void setImages(Collection<ImageForEmbeddableBag> images) {
		this.images = images;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithEmbeddableBag that = (ItemWithEmbeddableBag) o;

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
		return "ItemWithEmbeddableBag{" +
				"id=" + id +
				", images=" + images +
				'}';
	}
}
