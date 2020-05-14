package org.bear.model.constraints.single_row_table_constraint;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Check;

@Entity
@Table(catalog = "sample", schema = "public", name = "item_with_single_row_table_constraint")
@Check(constraints = "auctionStart < auctionEnd")
public class ItemWithSingleRowTableConstraint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotNull
	protected Date auctionStart;

	@NotNull
	protected Date auctionEnd;

	public ItemWithSingleRowTableConstraint() {
	}

	public ItemWithSingleRowTableConstraint(@NotNull Date auctionStart, @NotNull Date auctionEnd) {
		this.auctionStart = auctionStart;
		this.auctionEnd = auctionEnd;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getAuctionStart() {
		return auctionStart;
	}

	public void setAuctionStart(Date auctionStart) {
		this.auctionStart = auctionStart;
	}

	public Date getAuctionEnd() {
		return auctionEnd;
	}

	public void setAuctionEnd(Date auctionEnd) {
		this.auctionEnd = auctionEnd;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		ItemWithSingleRowTableConstraint that = (ItemWithSingleRowTableConstraint) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if(getAuctionStart() != null ? !getAuctionStart().equals(that.getAuctionStart()) : that.getAuctionStart() != null) return false;
		return getAuctionEnd() != null ? getAuctionEnd().equals(that.getAuctionEnd()) : that.getAuctionEnd() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getAuctionStart() != null ? getAuctionStart().hashCode() : 0);
		result = 31 * result + (getAuctionEnd() != null ? getAuctionEnd().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "ItemWithSingleRowTableConstraint{" +
				"id=" + id +
				", auctionStart=" + auctionStart +
				", auctionEnd=" + auctionEnd +
				'}';
	}
}
