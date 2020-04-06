package org.bear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(catalog = "sample", schema = "public", name = "office")
public class Office {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "office_generator")
	@SequenceGenerator(name = "office_generator", sequenceName = "office_seq", allocationSize = 1)
	@Column(name = "office", nullable = false)
	private Integer id;

	private Location location;

	@OneToMany(mappedBy = "office")
	private List<Employee> employers = new ArrayList<>();

	@ManyToOne
	@JoinColumn(name = "manager")
	private Employee manager;

	@Column(name = "target")
	private BigDecimal target;

	@Column(name = "sales", nullable = false)
	private BigDecimal sales;

	public void addEmployee(Employee employee) {
		employers.add(employee);
		employee.setOffice(this);
	}

	public void removeEmployee(Employee employee) {
		employers.remove(employee);
		employee.setOffice(null);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public BigDecimal getTarget() {
		return target;
	}

	public void setTarget(BigDecimal target) {
		this.target = target;
	}

	public BigDecimal getSales() {
		return sales;
	}

	public void setSales(BigDecimal sales) {
		this.sales = sales;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Office office = (Office) o;

		if(!getId().equals(office.getId())) return false;
		if(!getLocation().equals(office.getLocation())) return false;
		if(getManager() != null ? !getManager().equals(office.getManager()) : office.getManager() != null)
			return false;
		if(getTarget() != null ? !getTarget().equals(office.getTarget()) : office.getTarget() != null) return false;
		return getSales().equals(office.getSales());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getLocation().hashCode();
		result = 31 * result + (getManager() != null ? getManager().hashCode() : 0);
		result = 31 * result + (getTarget() != null ? getTarget().hashCode() : 0);
		result = 31 * result + getSales().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Office{" +
				"id=" + id +
				", location=" + location +
				", manager=" + manager.getId() +
				", target=" + target +
				", sales=" + sales +
				'}';
	}
}
