package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_many.one_to_many_with_bags.BidForOneToManyWithBags;
import org.bear.model.one_to_many.one_to_many_with_bags.ItemWithOneToManyWithBags;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		ItemWithOneToManyWithBags item = new ItemWithOneToManyWithBags();
		entityManager.persist(item);

		BidForOneToManyWithBags bid = new BidForOneToManyWithBags(item);
		item.getBids().add(bid);
		item.getBids().add(bid);
		entityManager.persist(bid);

		entityManager.getTransaction().commit();
	}
}
