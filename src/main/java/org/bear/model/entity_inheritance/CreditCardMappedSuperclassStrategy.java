package org.bear.model.entity_inheritance;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Mapped superclass inheritance strategy example

@Entity
@AttributeOverride(name = "owner",
		column = @Column(name = "CC_OWNER", nullable = false))
@Table(catalog = "sample", schema = "\"public\"", name = "credit_card_mapped_superclass")
public class CreditCardMappedSuperclassStrategy extends BillingDetailsMappedSuperclassStrategy {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "card_number", nullable = false)
	private String cardNumber;

	@Column(name = "exp_month", nullable = false)
	private String expMonth;

	@Column(name = "exp_year", nullable = false)
	private String expYear;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

		CreditCardMappedSuperclassStrategy that = (CreditCardMappedSuperclassStrategy) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if(getCardNumber() != null ? !getCardNumber().equals(that.getCardNumber()) : that.getCardNumber() != null) return false;
		if(getExpMonth() != null ? !getExpMonth().equals(that.getExpMonth()) : that.getExpMonth() != null) return false;
		return getExpYear() != null ? getExpYear().equals(that.getExpYear()) : that.getExpYear() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getCardNumber() != null ? getCardNumber().hashCode() : 0);
		result = 31 * result + (getExpMonth() != null ? getExpMonth().hashCode() : 0);
		result = 31 * result + (getExpYear() != null ? getExpYear().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CreditCard{" +
				"id=" + id +
				", cardNumber='" + cardNumber + '\'' +
				", expMonth='" + expMonth + '\'' +
				", expYear='" + expYear + '\'' +
				'}';
	}
}
