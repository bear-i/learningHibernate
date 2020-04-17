package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_one.foreign_key_generator.AddressWithForeignKeyGenerator;
import org.bear.model.one_to_one.foreign_key_generator.UserWithForeignKeyGenerator;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		UserWithForeignKeyGenerator user = new UserWithForeignKeyGenerator();
		AddressWithForeignKeyGenerator address = new AddressWithForeignKeyGenerator(user, "BBBBBB", "street1", "city1");
		user.setAddress(address);

		entityManager.persist(user);
		entityManager.getTransaction().commit();
	}
}
