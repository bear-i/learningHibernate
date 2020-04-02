package org.bear.model.entity_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Table-per-class with unions inheritance strategy example

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "credit_card01")
public class CreditCard01 extends BillingDetails01 {

	@Column(name = "card_number", nullable = false)
	private String cardNumber;

	@Column(name = "exp_month", nullable = false)
	private String expMonth;

	@Column(name = "exp_year", nullable = false)
	private String expYear;

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getExpMonth() {
		return expMonth;
	}

	public void setExpMonth(String expMonth) {
		this.expMonth = expMonth;
	}

	public String getExpYear() {
		return expYear;
	}

	public void setExpYear(String expYear) {
		this.expYear = expYear;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;
		if(!super.equals(o)) return false;

		CreditCard01 that = (CreditCard01) o;

		if(getCardNumber() != null ? !getCardNumber().equals(that.getCardNumber()) : that.getCardNumber() != null) return false;
		if(getExpMonth() != null ? !getExpMonth().equals(that.getExpMonth()) : that.getExpMonth() != null) return false;
		return getExpYear() != null ? getExpYear().equals(that.getExpYear()) : that.getExpYear() == null;
	}

	@Override
	public int hashCode() {
		int result = super.hashCode();
		result = 31 * result + (getCardNumber() != null ? getCardNumber().hashCode() : 0);
		result = 31 * result + (getExpMonth() != null ? getExpMonth().hashCode() : 0);
		result = 31 * result + (getExpYear() != null ? getExpYear().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CreditCard01{" +
				"cardNumber='" + cardNumber + '\'' +
				", expMonth='" + expMonth + '\'' +
				", expYear='" + expYear + '\'' +
				'}';
	}
}
