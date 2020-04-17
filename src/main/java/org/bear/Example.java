package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_one.foreign_key_join_column.AddressWithForeignKeyJoinColumn;
import org.bear.model.one_to_one.foreign_key_join_column.UserWithForeignKeyJoinColumn;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		UserWithForeignKeyJoinColumn user = new UserWithForeignKeyJoinColumn();
		AddressWithForeignKeyJoinColumn address = new AddressWithForeignKeyJoinColumn("CCCCCC", "street2", "city2");
		user.setAddress(address);

		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
}
