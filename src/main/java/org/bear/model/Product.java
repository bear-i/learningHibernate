package org.bear.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.math.BigDecimal;

import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.Formula;

@Entity
@Table(catalog = "sample", schema = "public", name = "product")
public class Product {

	@EmbeddedId
	private ProductIdentificator productIdentificator;

	@Column(name = "description", nullable = false, length = 20)
	private String description;

	@Column(name = "price", nullable = false)
	@ColumnTransformer(
			read = "price + 50",
			write = "? - 50"
	)
	private BigDecimal price;

	@Column(name = "quantity_on_hand", nullable = false)
	private Integer quantityOnHand;

	@Formula(value = "price * qty_on_hand")
	private BigDecimal maxPrice;

	public ProductIdentificator getProductIdentificator() {
		return productIdentificator;
	}

	public void setProductIdentificator(ProductIdentificator productIdentificator) {
		this.productIdentificator = productIdentificator;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(Integer quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public BigDecimal getMaxPrice() {
		return maxPrice;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Product product = (Product) o;

		if(!getProductIdentificator().equals(product.getProductIdentificator())) return false;
		if(!getDescription().equals(product.getDescription())) return false;
		if(!getPrice().equals(product.getPrice())) return false;
		return getQuantityOnHand().equals(product.getQuantityOnHand());
	}

	@Override
	public int hashCode() {
		int result = getProductIdentificator().hashCode();
		result = 31 * result + getDescription().hashCode();
		result = 31 * result + getPrice().hashCode();
		result = 31 * result + getQuantityOnHand().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Product{" +
				"productIdentificator=" + productIdentificator +
				", description='" + description + '\'' +
				", price=" + price +
				", quantityOnHand=" + quantityOnHand +
				"max price: " + maxPrice +
				'}';
	}

	@Embeddable
	public static class ProductIdentificator implements Serializable {

		@Column(name = "series", nullable = false, updatable = false, length = 3)
		private String series;

		@Column(name = "serial_number", nullable = false, updatable = false, length = 5)
		private String serial_number;

		public String getSeries() {
			return series;
		}

		public void setSeries(String series) {
			this.series = series;
		}

		public String getSerial_number() {
			return serial_number;
		}

		public void setSerial_number(String serial_number) {
			this.serial_number = serial_number;
		}

		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;

			ProductIdentificator that = (ProductIdentificator) o;

			if(getSeries() != null ? !getSeries().equals(that.getSeries()) : that.getSeries() != null) return false;
			return getSerial_number() != null ? getSerial_number().equals(that.getSerial_number()) : that.getSerial_number() == null;
		}

		@Override
		public int hashCode() {
			int result = getSeries() != null ? getSeries().hashCode() : 0;
			result = 31 * result + (getSerial_number() != null ? getSerial_number().hashCode() : 0);
			return result;
		}

		@Override
		public String toString() {
			return "ProductIdentificator{" +
					"series='" + series + '\'' +
					", serial_number='" + serial_number + '\'' +
					'}';
		}
	}
}
