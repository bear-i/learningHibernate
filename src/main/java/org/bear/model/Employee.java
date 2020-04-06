package org.bear.model;

import static javax.persistence.GenerationType.SEQUENCE;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.AttributeConverter;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = SEQUENCE, generator = "employee_generator")
	@SequenceGenerator(name = "employee_generator", sequenceName = "employee_seq", allocationSize = 1)
	@Column(name = "empl_num")
	private Integer id;

	@Column(name = "\"name\"", length = 15, nullable = false)
	private String emplName;

	@Column(name = "age")
	private Integer age;

	@ManyToOne
	@JoinColumn(name = "empl_office")
	private Office office;

	@Column(name = "title", length = 10)
	@Convert(converter = TitleConverter.class)
	private Title title;

	@Temporal(TemporalType.DATE)
	@CreationTimestamp
	@Column(name = "hire_date", nullable = false, updatable = false)
	private Date hireDate;

	@ManyToOne
	@JoinColumn(name = "manager")
	private Employee manager;

	@Column(name = "quota")
	private BigDecimal quota;

	@Column(name = "sales", nullable = false)
	private BigDecimal sales;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmplName() {
		return emplName;
	}

	public void setEmplName(String emplName) {
		this.emplName = emplName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Office getOffice() {
		return office;
	}

	public void setOffice(Office office) {
		this.office = office;
	}

	public Title getTitle() {
		return title;
	}

	public void setTitle(Title title) {
		this.title = title;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Employee getManager() {
		return manager;
	}

	public void setManager(Employee manager) {
		this.manager = manager;
	}

	public BigDecimal getQuota() {
		return quota;
	}

	public void setQuota(BigDecimal quota) {
		this.quota = quota;
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

		Employee employee = (Employee) o;

		if(!getId().equals(employee.getId())) return false;
		if(!getEmplName().equals(employee.getEmplName())) return false;
		if(getAge() != null ? !getAge().equals(employee.getAge()) : employee.getAge() != null) return false;
		if(getOffice() != null ? !getOffice().equals(employee.getOffice()) : employee.getOffice() != null) return false;
		if(getTitle() != employee.getTitle()) return false;
		if(!getHireDate().equals(employee.getHireDate())) return false;
		if(getManager() != null ? !getManager().equals(employee.getManager()) : employee.getManager() != null) return false;
		if(getQuota() != null ? !getQuota().equals(employee.getQuota()) : employee.getQuota() != null) return false;
		return getSales().equals(employee.getSales());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getEmplName().hashCode();
		result = 31 * result + (getAge() != null ? getAge().hashCode() : 0);
		result = 31 * result + (getOffice() != null ? getOffice().hashCode() : 0);
		result = 31 * result + (getTitle() != null ? getTitle().hashCode() : 0);
		result = 31 * result + getHireDate().hashCode();
		result = 31 * result + (getManager() != null ? getManager().hashCode() : 0);
		result = 31 * result + (getQuota() != null ? getQuota().hashCode() : 0);
		result = 31 * result + getSales().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Employee{" +
				"id=" + id +
				", emplName='" + emplName + '\'' +
				", age=" + age +
				", office=" + office.getId() +
				", title=" + title +
				", hireDate=" + hireDate +
				", manager=" + manager +
				", quota=" + quota +
				", sales=" + sales +
				'}';
	}

	public static class TitleConverter implements AttributeConverter<Title, String>{

		public String convertToDatabaseColumn(Title title) {
			return title.toString();
		}

		public Title convertToEntityAttribute(String title) {
			return Title.valueOf(title.toUpperCase().replace(" ", "_"));
		}
	}
}
