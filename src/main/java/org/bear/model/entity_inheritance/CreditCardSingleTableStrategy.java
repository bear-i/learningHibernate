package org.bear.model.entity_inheritance;

//Single-table inheritance strategy example

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("credit_card")
public class CreditCardSingleTableStrategy extends BillingDetailsSingleTableStrategy {

	@NotNull
	@Column(name = "card_number")
	private String cardNumber;

	@NotNull
	@Column(name = "exp_month")
	private String expMonth;

	@NotNull
	@Column(name = "exp_year")
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

		CreditCardSingleTableStrategy that = (CreditCardSingleTableStrategy) o;

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
		return "CreditCard02{" +
				"cardNumber='" + cardNumber + '\'' +
				", expMonth='" + expMonth + '\'' +
				", expYear='" + expYear + '\'' +
				'}';
	}
}
