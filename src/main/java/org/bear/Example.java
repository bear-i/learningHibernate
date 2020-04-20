package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_many.one_to_many_with_list.BidForOneToManyWithList;
import org.bear.model.one_to_many.one_to_many_with_list.ItemWithOneToManyWithList;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		ItemWithOneToManyWithList item = new ItemWithOneToManyWithList();
		entityManager.persist(item);

		BidForOneToManyWithList bid1 = new BidForOneToManyWithList();
		BidForOneToManyWithList bid2 = new BidForOneToManyWithList();
		item.getBids().add(bid1);
		item.getBids().add(bid2);
		entityManager.persist(bid1);
		entityManager.persist(bid2);

		entityManager.getTransaction().commit();
	}
}
