package org.bear.model.entity_inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

//Table-per-class with unions inheritance strategy example

@Entity
@Table(catalog = "sample", schema = "\"public\"", name = "bank_account01")
public class BankAccount01 extends BillingDetails01 {

	@Column(name = "account", nullable = false)
	private String account;

	@Column(name = "bank_name", nullable = false)
	private String bankName;

	@Column(name = "swift", nullable = false)
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

		BankAccount01 that = (BankAccount01) o;

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
		return "BankAccount01{" +
				"account='" + account + '\'' +
				", bankName='" + bankName + '\'' +
				", swift='" + swift + '\'' +
				'}';
	}
}
