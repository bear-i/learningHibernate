package org.bear.model.embeddable_inheritance;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
		@AttributeOverride(name = "forename", column = @Column(name = "dimensions_name")),
		@AttributeOverride(name = "symbol", column = @Column(name = "dimensions_symbol"))
})
public class Dimensions extends Measurement {

	@Column(name = "depth")
	private BigDecimal depth;

	@Column(name = "height")
	private BigDecimal height;

	@Column(name = "width")
	private BigDecimal width;

	public BigDecimal getDepth() {
		return depth;
	}

	public void setDepth(BigDecimal depth) {
		this.depth = depth;
	}

	public BigDecimal getHeight() {
		return height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public BigDecimal getWidth() {
		return width;
	}

	public void setWidth(BigDecimal width) {
		this.width = width;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;

		Dimensions that = (Dimensions) o;

		if(getDepth() != null ? !getDepth().equals(that.getDepth()) : that.getDepth() != null) return false;
		if(getHeight() != null ? !getHeight().equals(that.getHeight()) : that.getHeight() != null) return false;
		return getWidth() != null ? getWidth().equals(that.getWidth()) : that.getWidth() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getDepth() != null ? getDepth().hashCode() : 0);
		result = 31 * result + (getHeight() != null ? getHeight().hashCode() : 0);
		result = 31 * result + (getWidth() != null ? getWidth().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Dimensions{" +
				"depth=" + depth +
				", height=" + height +
				", width=" + width +
				'}';
	}
}
