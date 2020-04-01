package org.bear;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.Address;
import org.bear.model.Customer;
import org.bear.model.CustomerProfile;
import org.bear.model.Employee;
import org.bear.model.Product;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
//		EntityManager entityManager = entityManagerFactory.createEntityManager();

//		entityManager.getTransaction().begin();
//
//		Product product = new Product();
//
//		Product.PrimaryKey pk = new Product.PrimaryKey();
//		pk.setMfr("ABC");
//		pk.setProduct("AB2C3");
//		product.setPrimaryKey(pk);
//
//		product.setDescription("description");
//		product.setQuantityOnHand(5);
//		product.setPrice(BigDecimal.valueOf(1000));
//
//		entityManager.persist(product);
//		entityManager.getTransaction().commit();
//
//		System.out.println("Product saved:" + product + "\n");

//		Employee manager = entityManager.find(Employee.class, 106);
//		System.out.println(manager);
//		Office office = entityManager.find(Office.class, 22);
//		System.out.println(office);
//
//		entityManager.getTransaction().begin();
//
//		Employee employee = new Employee();
//		employee.setEmplName("John Snow");
//		employee.setAge(22);
//		employee.setOffice(office);
//		employee.setManager(manager);
//		employee.setTitle(Title.SALES_REP);
//		employee.setQuota(BigDecimal.valueOf(15000));
//		employee.setSales(BigDecimal.valueOf(2000));
//
//		entityManager.persist(employee);
//		entityManager.getTransaction().commit();
//
//		System.out.println("Employee saved: "+ employee + "\n");

//		Customer customer = entityManager.find(Customer.class, 2111);
//		System.out.println(customer);
//		Employee consultant = entityManager.find(Employee.class, 109);
//		System.out.println(consultant);
//		Product.PrimaryKey primaryKey2 = new Product.PrimaryKey();
//		primaryKey2.setMfr("REI");
//		primaryKey2.setProduct("2A45C");
//		Product product2 = entityManager.find(Product.class, primaryKey2);
//		System.out.println(product2);
//
//		entityManager.getTransaction().begin();
//
//		Order order = new Order();
//		order.setProduct(product2);
//		order.setCustomer(customer);
//		order.setConsultant(consultant);
//		order.setQuantity(5);
//		order.setAmount(BigDecimal.valueOf(10000));
//
//		entityManager.persist(order);
//		entityManager.getTransaction().commit();
//		System.out.println("Order saved:" + order);

//		entityManager.getTransaction().begin();
//
//		Address address = new Address();
//		address.setCity("Atlanta");
//		address.setStreet("street");
//		address.setZipcode("AAAAAA");
//
//		Address billingAddress = new Address();
//		billingAddress.setCity("LA");
//		billingAddress.setStreet("street1");
//		billingAddress.setZipcode("AAAAAB");
//
//		CustomerProfile customerProfile = new CustomerProfile();
//		customerProfile.setAddress(address);
//		customerProfile.setBillingAddress(billingAddress);
//
//		Employee consultant = entityManager.find(Employee.class, 106);
//
//		Customer customer = new Customer();
//		customer.setCompanyName("companyName");
//		customer.setConsultant(consultant);
//		customer.setCustomerProfile(customerProfile);
//		customer.setCreditLimit(BigDecimal.valueOf(100000));
//
//		customerProfile.setCustomer(customer);
//
//		entityManager.persist(customer);
//		entityManager.getTransaction().commit();

	}
}
