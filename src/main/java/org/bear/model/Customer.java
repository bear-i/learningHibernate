package org.bear.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(catalog = "sample", schema = "public", name = "customer")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "customer_generator")
	@SequenceGenerator(name = "customer_generator", sequenceName = "customer_seq", allocationSize = 1)
	@Column(name = "cust_num", nullable = false, updatable = false)
	private Integer id;

	@Column(name = "company", nullable = false, length = 20)
	private String companyName;

	@ManyToOne
	@JoinColumn(name = "cust_consultant")
	private Employee consultant;

	@Column(name = "credit_limit")
	private BigDecimal creditLimit;

	@OneToOne(mappedBy = "customer", orphanRemoval = true, cascade = CascadeType.ALL)
	private CustomerProfile customerProfile;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Employee getConsultant() {
		return consultant;
	}

	public void setConsultant(Employee consultant) {
		this.consultant = consultant;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public CustomerProfile getCustomerProfile() {
		return customerProfile;
	}

	public void setCustomerProfile(CustomerProfile customerProfile) {
		this.customerProfile = customerProfile;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Customer customer = (Customer) o;

		if(!getId().equals(customer.getId())) return false;
		if(!getCompanyName().equals(customer.getCompanyName())) return false;
		if(getConsultant() != null
				? !getConsultant().equals(customer.getConsultant())
				: customer.getConsultant() != null) {
			return false;
		}
		return getCreditLimit() != null ? getCreditLimit().equals(customer.getCreditLimit()) : customer.getCreditLimit() == null;
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getCompanyName().hashCode();
		result = 31 * result + (getConsultant() != null ? getConsultant().hashCode() : 0);
		result = 31 * result + (getCreditLimit() != null ? getCreditLimit().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Customer{" +
				"id=" + id +
				", companyName='" + companyName + '\'' +
				", consultant=" + consultant +
				", creditLimit=" + creditLimit +
				'}';
	}
}
