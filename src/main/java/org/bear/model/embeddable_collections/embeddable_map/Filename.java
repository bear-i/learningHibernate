package org.bear.model.embeddable_collections.embeddable_map;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Filename {

	@Column(name = "forename", nullable = false)
	private String name;

	@Column(name = "extension", nullable = false)
	private String extension;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Filename filename = (Filename) o;

		if(getName() != null ? !getName().equals(filename.getName()) : filename.getName() != null) return false;
		return getExtension() != null ? getExtension().equals(filename.getExtension()) : filename.getExtension() == null;
	}

	@Override
	public int hashCode() {
		int result = getName() != null ? getName().hashCode() : 0;
		result = 31 * result + (getExtension() != null ? getExtension().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Filename{" +
				"name='" + name + '\'' +
				", extension='" + extension + '\'' +
				'}';
	}
}
