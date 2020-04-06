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
@Table(name = "product")
public class Product {

	@EmbeddedId
	private PrimaryKey primaryKey;

	@Column(name = "description", nullable = false, length = 20)
	private String description;

	@Column(name = "price", nullable = false)
	@ColumnTransformer(
			read = "price + 50",
			write = "? - 50"
	)
	private BigDecimal price;

	@Column(name = "qty_on_hand", nullable = false)
	private Integer quantityOnHand;

	@Formula(value = "price * qty_on_hand")
	private BigDecimal maxPrice;

	public PrimaryKey getPrimaryKey() {
		return primaryKey;
	}

	public void setPrimaryKey(PrimaryKey primaryKey) {
		this.primaryKey = primaryKey;
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

		if(!getPrimaryKey().equals(product.getPrimaryKey())) return false;
		if(!getDescription().equals(product.getDescription())) return false;
		if(!getPrice().equals(product.getPrice())) return false;
		return getQuantityOnHand().equals(product.getQuantityOnHand());
	}

	@Override
	public int hashCode() {
		int result = getPrimaryKey().hashCode();
		result = 31 * result + getDescription().hashCode();
		result = 31 * result + getPrice().hashCode();
		result = 31 * result + getQuantityOnHand().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Product{" +
				"primaryKey=" + primaryKey +
				", description='" + description + '\'' +
				", price=" + price +
				", quantityOnHand=" + quantityOnHand +
				"max price: " + maxPrice +
				'}';
	}

	@Embeddable
	public static class PrimaryKey implements Serializable {

		@Column(name = "mfr_id", nullable = false, updatable = false, length = 3)
		private String mfr;

		@Column(name = "product_id", nullable = false, updatable = false, length = 5)
		private String product;

		public String getMfr() {
			return mfr;
		}

		public void setMfr(String mfr) {
			this.mfr = mfr;
		}

		public String getProduct() {
			return product;
		}

		public void setProduct(String product) {
			this.product = product;
		}

		@Override
		public boolean equals(Object o) {
			if(this == o) return true;
			if(o == null || getClass() != o.getClass()) return false;

			PrimaryKey primaryKey = (PrimaryKey) o;

			if(!getMfr().equals(primaryKey.getMfr())) return false;
			return getProduct().equals(primaryKey.getProduct());
		}

		@Override
		public int hashCode() {
			int result = getMfr().hashCode();
			result = 31 * result + getProduct().hashCode();
			return result;
		}

		@Override
		public String toString() {
			return "PrimaryKey{" +
					"mfr='" + mfr + '\'' +
					", product='" + product + '\'' +
					'}';
		}
	}
}
