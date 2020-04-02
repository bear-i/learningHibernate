package org.bear.model.inheritance;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Mapped superclass inheritance strategy example

@Entity
@Table(name = "bank_account")
public class BankAccount00 extends BillingDetails00 {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "account", nullable = false)
	private String account;

	@Column(name = "bank_name", nullable = false)
	private String bankName;

	@Column(name = "swift", nullable = false)
	private String swift;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankname) {
		this.bankName = bankname;
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

		BankAccount00 that = (BankAccount00) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if(getAccount() != null ? !getAccount().equals(that.getAccount()) : that.getAccount() != null) return false;
		if(getBankName() != null ? !getBankName().equals(that.getBankName()) : that.getBankName() != null) return false;
		return getSwift() != null ? getSwift().equals(that.getSwift()) : that.getSwift() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getAccount() != null ? getAccount().hashCode() : 0);
		result = 31 * result + (getBankName() != null ? getBankName().hashCode() : 0);
		result = 31 * result + (getSwift() != null ? getSwift().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "BankAccount{" +
				"id=" + id +
				", account='" + account + '\'' +
				", bankname='" + bankName + '\'' +
				", swift='" + swift + '\'' +
				'}';
	}
}
