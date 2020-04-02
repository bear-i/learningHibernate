package org.bear.model;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "customer_profile")
public class CustomerProfile {

	@Id
	@Column(name = "cust_num")
	private Integer id;

	private Address address;

	@AttributeOverrides({
			@AttributeOverride(
					name = "zipcode",
					column = @Column(name = "billing_zipcode", length = 6)
			),
			@AttributeOverride(
					name = "street",
					column = @Column(name = "billing_street", length = 15)
			),
			@AttributeOverride(
					name = "city",
					column = @Column(name = "billing_city", length = 15)
			)
	})
	private Address billingAddress;

	@OneToOne
	@MapsId
	@JoinColumn(name = "cust_num", nullable = false)
	private	Customer customer;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Address getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(Address billingAddress) {
		this.billingAddress = billingAddress;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
//		this.id = customer.getId();
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		CustomerProfile that = (CustomerProfile) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if(getAddress() != null ? !getAddress().equals(that.getAddress()) : that.getAddress() != null) return false;
		if(getBillingAddress() != null ? !getBillingAddress().equals(that.getBillingAddress()) : that.getBillingAddress() != null) return false;
		return getCustomer() != null ? getCustomer().equals(that.getCustomer()) : that.getCustomer() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
		result = 31 * result + (getBillingAddress() != null ? getBillingAddress().hashCode() : 0);
		result = 31 * result + (getCustomer() != null ? getCustomer().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "CustomerProfile{" +
				"id=" + id +
				", address=" + address +
				", billingAddress=" + billingAddress +
				", customer=" + customer.getId() +
				'}';
	}
}
