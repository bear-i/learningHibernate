package org.bear.model.one_to_one.foreign_key_join_column;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "address_with_foreign_key_join_column")
public class AddressWithForeignKeyJoinColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "zipcode", length = 6)
	private String zipcode;

	@Column(name = "street", length = 15)
	private String street;

	@Column(name = "city", length = 15)
	private String city;

	public AddressWithForeignKeyJoinColumn() {
	}

	public AddressWithForeignKeyJoinColumn(String zipcode, String street, String city) {
		this.zipcode = zipcode;
		this.street = street;
		this.city = city;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

		AddressWithForeignKeyJoinColumn that = (AddressWithForeignKeyJoinColumn) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if(getZipcode() != null ? !getZipcode().equals(that.getZipcode()) : that.getZipcode() != null) return false;
		if(getStreet() != null ? !getStreet().equals(that.getStreet()) : that.getStreet() != null) return false;
		return getCity() != null ? getCity().equals(that.getCity()) : that.getCity() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getZipcode() != null ? getZipcode().hashCode() : 0);
		result = 31 * result + (getStreet() != null ? getStreet().hashCode() : 0);
		result = 31 * result + (getCity() != null ? getCity().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "AddressWithForeignKeyJoinColumn{" +
				"id=" + id +
				", zipcode='" + zipcode + '\'' +
				", street='" + street + '\'' +
				", city='" + city + '\'' +
				'}';
	}
}
