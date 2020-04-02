package org.bear.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import java.math.BigDecimal;
import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;

@Entity
@Table(catalog = "sample", schema = "public", name = "\"order\"")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "order_generator")
    @SequenceGenerator(name = "order_generator", sequenceName = "order_seq", allocationSize = 1)
    @Column(name = "order_num")
    private Integer id;

    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    @Column(name = "order_date", nullable = false, updatable = false)
    private Date orderDate;

	@ManyToOne
    @JoinColumn(name = "cust", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "consultant")
    private Employee consultant;

    @ManyToOne
	@JoinColumns({
			@JoinColumn(name = "product_series", referencedColumnName = "series"),
			@JoinColumn(name = "product_serial_number", referencedColumnName = "serial_number")})
	private Product product;

    @Column(name = "quantity", nullable = false)
    private Integer quantity;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Employee getConsultant() {
		return consultant;
	}

	public void setConsultant(Employee consultant) {
		this.consultant = consultant;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public boolean equals(Object o) {
		if(this == o) return true;
		if(o == null || getClass() != o.getClass()) return false;

		Order order = (Order) o;

		if(!getId().equals(order.getId())) return false;
		if(!getOrderDate().equals(order.getOrderDate())) return false;
		if(!getCustomer().equals(order.getCustomer())) return false;
		if(getConsultant() != null ? !getConsultant().equals(order.getConsultant()) : order.getConsultant() != null) return false;
		if(!getProduct().equals(order.getProduct())) return false;
		if(!getQuantity().equals(order.getQuantity())) return false;
		return getAmount().equals(order.getAmount());
	}

	@Override
	public int hashCode() {
		int result = getId().hashCode();
		result = 31 * result + getOrderDate().hashCode();
		result = 31 * result + getCustomer().hashCode();
		result = 31 * result + (getConsultant() != null ? getConsultant().hashCode() : 0);
		result = 31 * result + getProduct().hashCode();
		result = 31 * result + getQuantity().hashCode();
		result = 31 * result + getAmount().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "Order{" +
				"id=" + id +
				", orderDate=" + orderDate +
				", customer=" + customer.getId() +
				", consultant=" + consultant.getId() +
				", product=" + product.getProductIdentificator() +
				", quantity=" + quantity +
				", amount=" + amount +
				'}';
	}
}
