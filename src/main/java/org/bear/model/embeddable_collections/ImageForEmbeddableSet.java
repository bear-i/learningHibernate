package org.bear.model.embeddable_collections;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import org.hibernate.annotations.Parent;

@Embeddable
public class ImageForEmbeddableSet {

	@Parent
	private ItemWithEmbeddableSet item;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "filename", nullable = false)
	private String filename;

	@Column(name = "width", nullable = false)
	private int width;

	@Column(name = "height", nullable = false)
	private int height;

	public ItemWithEmbeddableSet getItem() {
		return item;
	}

	public void setItem(ItemWithEmbeddableSet item) {
		this.item = item;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ImageForEmbeddableSet that = (ImageForEmbeddableSet) o;

		if(getWidth() != that.getWidth()) return false;
		if(getHeight() != that.getHeight()) return false;
		if(item != null ? !item.getId().equals(that.item.getId()) : that.item != null) return false;
		if(getTitle() != null ? !getTitle().equals(that.getTitle()) : that.getTitle() != null) return false;
		return getFilename() != null ? getFilename().equals(that.getFilename()) : that.getFilename() == null;
	}

	@Override
	public int hashCode() {
		int result = item != null ? item.hashCode() : 0;
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + (getFilename() != null ? getFilename().hashCode() : 0);
		result = 31 * result + getWidth();
		result = 31 * result + getHeight();
		return result;
	}

	@Override
	public String toString() {
		return "Image{" +
				"title='" + title + '\'' +
				", filename='" + filename + '\'' +
				", width=" + width +
				", height=" + height +
				'}';
	}
}
