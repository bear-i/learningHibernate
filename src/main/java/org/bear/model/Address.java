package org.bear.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name = "zipcode", length = 6)
	private String zipcode;

	@Column(name = "street", length = 15)
	private String street;

	@Column(name = "city", length = 15)
	private String city;

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Address address = (Address) o;

		if(getZipcode() != null ? !getZipcode().equals(address.getZipcode()) : address.getZipcode() != null) return false;
		if(getStreet() != null ? !getStreet().equals(address.getStreet()) : address.getStreet() != null) return false;
		return getCity() != null ? getCity().equals(address.getCity()) : address.getCity() == null;
	}

	@Override
	public int hashCode() {
		int result = getZipcode() != null ? getZipcode().hashCode() : 0;
		result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
		result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Address{" +
				"zipcode='" + zipcode + '\'' +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
