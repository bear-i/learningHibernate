package org.bear.model.one_to_one.primary_key_sharing;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(catalog = "sample", schema = "public", name = "user_with_primary_key_sharing_strategy")
public class UserWithPrimaryKeySharingStrategy {

	@Id
	private Long id;

	@OneToOne(
			fetch = FetchType.LAZY,
			optional = false
	)
	@PrimaryKeyJoinColumn
	private AddressWithPrimaryKeySharingStrategy shippingAddress;

	public UserWithPrimaryKeySharingStrategy() {
	}

	public UserWithPrimaryKeySharingStrategy(Long id, AddressWithPrimaryKeySharingStrategy shippingAddress) {
		this.id = id;
		this.shippingAddress = shippingAddress;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public AddressWithPrimaryKeySharingStrategy getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(AddressWithPrimaryKeySharingStrategy shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		UserWithPrimaryKeySharingStrategy user = (UserWithPrimaryKeySharingStrategy) o;

		if(getId() != null ? !getId().equals(user.getId()) : user.getId() != null) return false;
		return getShippingAddress() != null ? getShippingAddress().equals(user.getShippingAddress()) : user.getShippingAddress() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getShippingAddress() != null ? getShippingAddress().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "User{" +
				"id=" + id +
				", shippingAddress=" + shippingAddress +
				'}';
	}
}
