package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_many.one_to_many_with_join_table.ItemWithOneToManyWithJoinTable;
import org.bear.model.one_to_many.one_to_many_with_join_table.UserWithOneToManyWithJoinTable;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		UserWithOneToManyWithJoinTable userWithOneToManyWithJoinTable = new UserWithOneToManyWithJoinTable();

		ItemWithOneToManyWithJoinTable item1 = new ItemWithOneToManyWithJoinTable();
		item1.setBuyer(userWithOneToManyWithJoinTable);
		entityManager.persist(userWithOneToManyWithJoinTable);
		entityManager.persist(item1);

		entityManager.getTransaction().commit();
	}
}
