package org.bear.model.embeddable_collections.embeddable_map;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ImageForEmbeddableMap {

	@Column(name = "title")
	private String title;

	@Column(name = "width")
	private int width;

	@Column(name = "height")
	private int height;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

		ImageForEmbeddableMap that = (ImageForEmbeddableMap) o;

		if(getWidth() != that.getWidth()) return false;
		if(getHeight() != that.getHeight()) return false;
		return getTitle() != null ? getTitle().equals(that.getTitle()) : that.getTitle() == null;
	}

	@Override
	public int hashCode() {
		int result = getTitle() != null ? getTitle().hashCode() : 0;
		result = 31 * result + getWidth();
		result = 31 * result + getHeight();
		return result;
	}

	@Override
	public String toString() {
		return "ImageForEmbeddableMap{" +
				"title='" + title + '\'' +
				", width=" + width +
				", height=" + height +
				'}';
	}
}
