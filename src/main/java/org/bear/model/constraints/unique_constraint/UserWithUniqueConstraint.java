package org.bear.model.constraints.unique_constraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(catalog = "sample", schema = "public", name = "user_with_unique_constraint",
		uniqueConstraints = @UniqueConstraint(name = "unq_username_email", columnNames = {"username", "email"}))
public class UserWithUniqueConstraint {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	public UserWithUniqueConstraint() {
	}

	public UserWithUniqueConstraint(String username, String email) {
		this.username = username;
		this.email = email;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		UserWithUniqueConstraint that = (UserWithUniqueConstraint) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		if(getUsername() != null ? !getUsername().equals(that.getUsername()) : that.getUsername() != null) return false;
		return getEmail() != null ? getEmail().equals(that.getEmail()) : that.getEmail() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
		result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UserWithUniqueConstraint{" +
				"id=" + id +
				", username='" + username + '\'' +
				", email='" + email + '\'' +
				'}';
	}
}
