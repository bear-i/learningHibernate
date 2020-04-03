package org.bear.model.embeddable_inheritance;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class Measurement {

	@Column(name = "forename")
	private String forename;

	@Column(name = "symbol")
	private String symbol;

	public String getForename() {
		return forename;
	}

	public void setForename(String forename) {
		this.forename = forename;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Measurement that = (Measurement) o;

		if(getForename() != null ? !getForename().equals(that.getForename()) : that.getForename() != null) return false;
		return getSymbol() != null ? getSymbol().equals(that.getSymbol()) : that.getSymbol() == null;
	}

	@Override
	public int hashCode() {
		int result = getForename() != null ? getForename().hashCode() : 0;
		result = 31 * result + (getSymbol() != null ? getSymbol().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Measurement{" +
				"forename='" + forename + '\'' +
				", symbol='" + symbol + '\'' +
				'}';
	}
}
