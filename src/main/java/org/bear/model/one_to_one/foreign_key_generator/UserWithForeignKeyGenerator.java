package org.bear.model.one_to_one.foreign_key_generator;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "user_with_foreign_key_generator")
public class UserWithForeignKeyGenerator {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(
			mappedBy = "user",
			cascade = CascadeType.PERSIST
	)
	private AddressWithForeignKeyGenerator address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressWithForeignKeyGenerator getAddress() {
		return address;
	}

	public void setAddress(AddressWithForeignKeyGenerator address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		UserWithForeignKeyGenerator that = (UserWithForeignKeyGenerator) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getAddress() != null ? getAddress().equals(that.getAddress()) : that.getAddress() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getAddress() != null ? getAddress().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UserWithForeignKeyGenerator{" +
				"id=" + id +
				", address=" + address.getId() +
				'}';
	}
}
