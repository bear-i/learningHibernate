package org.bear.model.entity_inheritance;

//Single-table inheritance strategy example

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("bank_account")
public class BankAccount02 extends BillingDetails02 {

	@NotNull
	@Column(name = "account")
	private String account;

	@NotNull
	@Column(name = "bank_name")
	private String bankName;

	@NotNull
	@Column(name = "swift")
	private String swift;

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getSwift() {
		return swift;
	}

	public void setSwift(String swift) {
		this.swift = swift;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		BankAccount02 that = (BankAccount02) o;

		if(getAccount() != null ? !getAccount().equals(that.getAccount()) : that.getAccount() != null) return false;
		if(getBankName() != null ? !getBankName().equals(that.getBankName()) : that.getBankName() != null) return false;
		return getSwift() != null ? getSwift().equals(that.getSwift()) : that.getSwift() == null;
	}

	@Override
	public int hashCode() {
		int result = getAccount() != null ? getAccount().hashCode() : 0;
		result = 31 * result + (getBankName() != null ? getBankName().hashCode() : 0);
		result = 31 * result + (getSwift() != null ? getSwift().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BankAccount02{" +
				"account='" + account + '\'' +
				", bankName='" + bankName + '\'' +
				", swift='" + swift + '\'' +
				'}';
	}
}
