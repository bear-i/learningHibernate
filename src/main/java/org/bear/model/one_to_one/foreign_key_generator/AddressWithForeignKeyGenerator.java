package org.bear.model.one_to_one.foreign_key_generator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(catalog = "sample", schema = "public", name = "address_with_foreign_key_generator")
public class AddressWithForeignKeyGenerator {

	@Id
	@GeneratedValue(generator = "addressKeyGenerator")
	@GenericGenerator(
			name = "addressKeyGenerator",
			strategy = "foreign",
			parameters = {
					@Parameter(name = "property", value = "user")
			}
	)
	private Long id;

	@OneToOne(optional = false)
	@PrimaryKeyJoinColumn
	private UserWithForeignKeyGenerator user;

	@Column(name = "zipcode", length = 6)
	private String zipcode;

	@Column(name = "street", length = 15)
	private String street;

	@Column(name = "city", length = 15)
	private String city;

	public AddressWithForeignKeyGenerator() {
	}

	public AddressWithForeignKeyGenerator(UserWithForeignKeyGenerator user) {
		this.user = user;
	}

	public AddressWithForeignKeyGenerator(UserWithForeignKeyGenerator user, String zipcode, String street, String city) {
		this.user = user;
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

	public UserWithForeignKeyGenerator getUser() {
		return user;
	}

	public void setUser(UserWithForeignKeyGenerator user) {
		this.user = user;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		AddressWithForeignKeyGenerator that = (AddressWithForeignKeyGenerator) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getUser() != null ? getUser().equals(that.getUser()) : that.getUser() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getUser() != null ? getUser().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "AddressWithForeignKeyGenerator{" +
				"id=" + id +
				", user=" + user.getId() +
				'}';
	}
}
