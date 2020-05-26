package org.bear.model.constraints.single_column_constraint;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

@Entity
@Table(catalog = "sample", schema = "public", name = "user_with_single_column_constraint")
public class UserWithSingleColumnConstraint {

	@Version
	@Column(name = "instance_version")
	private Long version;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(
			name = "username",
			columnDefinition = "varchar(15) not null unique" + " check(not substring(lower(username), 0, 5) = 'admin')"
	)
	private String username;

	public UserWithSingleColumnConstraint() {
	}

	public UserWithSingleColumnConstraint(String username) {
		this.username = username;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getVersion() {
		return version;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		UserWithSingleColumnConstraint that = (UserWithSingleColumnConstraint) o;

		if(getId() != null ? !getId().equals(that.getId()) : that.getId() != null) return false;
		return getUsername() != null ? getUsername().equals(that.getUsername()) : that.getUsername() == null;
	}

	@Override
	public int hashCode() {
		int result = getId() != null ? getId().hashCode() : 0;
		result = 31 * result + (getUsername() != null ? getUsername().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "UserWithSingleColumnConstraint{" +
				"id=" + id +
				", username='" + username + '\'' +
				'}';
	}
}
