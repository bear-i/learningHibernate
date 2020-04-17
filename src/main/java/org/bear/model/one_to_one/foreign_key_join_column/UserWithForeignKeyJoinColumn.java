package org.bear.model.one_to_one.foreign_key_join_column;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "user_with_foreign_key_join_column")
public class UserWithForeignKeyJoinColumn {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne(
			fetch = FetchType.LAZY,
			optional = false,
			cascade = CascadeType.PERSIST
	)
	@JoinColumn(name = "address_id", unique = true)
	private AddressWithForeignKeyJoinColumn address;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressWithForeignKeyJoinColumn getAddress() {
		return address;
	}

	public void setAddress(AddressWithForeignKeyJoinColumn address) {
		this.address = address;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		UserWithForeignKeyJoinColumn that = (UserWithForeignKeyJoinColumn) o;

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
		return "UserWithForeignKeyJoinColumn{" +
				"id=" + id +
				", address=" + address.getId() +
				'}';
	}
}
