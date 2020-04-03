package org.bear.model.embeddable_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "item")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	private Dimensions dimensions;

	private Weight weight;

	public Dimensions getDimensions() {
		return dimensions;
	}

	public void setDimensions(Dimensions dimensions) {
		this.dimensions = dimensions;
	}

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Item item = (Item) o;

		if(getDimensions() != null ? !getDimensions().equals(item.getDimensions()) : item.getDimensions() != null) return false;
		return getWeight() != null ? getWeight().equals(item.getWeight()) : item.getWeight() == null;
	}

	@Override
	public int hashCode() {
		int result = getDimensions() != null ? getDimensions().hashCode() : 0;
		result = 31 * result + (getWeight() != null ? getWeight().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Item{" +
				"dimensions=" + dimensions +
				", weight=" + weight +
				'}';
	}
}
