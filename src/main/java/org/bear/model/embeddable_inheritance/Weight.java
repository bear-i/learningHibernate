package org.bear.model.embeddable_inheritance;

import java.math.BigDecimal;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@AttributeOverrides({
		@AttributeOverride(name = "forename", column = @Column(name = "weight_name")),
		@AttributeOverride(name = "symbol", column = @Column(name = "weight_symbol"))
})
public class Weight extends Measurement {

	@Column(name = "weight")
	private BigDecimal value;

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;

		Weight weight = (Weight) o;

		return getValue() != null ? getValue().equals(weight.getValue()) : weight.getValue() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Weight{" +
				"value=" + value +
				'}';
	}
}
