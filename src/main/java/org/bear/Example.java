package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_one.primary_key_sharing.AddressWithPrimaryKeySharingStrategy;
import org.bear.model.one_to_one.primary_key_sharing.UserWithPrimaryKeySharingStrategy;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		AddressWithPrimaryKeySharingStrategy address = new AddressWithPrimaryKeySharingStrategy("AAAAAA", "street", "city");

		entityManager.persist(address);

		UserWithPrimaryKeySharingStrategy user = new UserWithPrimaryKeySharingStrategy();
		user.setId(address.getId());
		user.setShippingAddress(address);
		entityManager.persist(user);

		entityManager.getTransaction().commit();
	}
}
