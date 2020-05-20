package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.constraints.single_column_constraint.UserWithSingleColumnConstraint;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			//Primary key depends on what you have in table
			UserWithSingleColumnConstraint user1 = entityManager.find(UserWithSingleColumnConstraint.class, 6L);

			user1.setUsername("Another username");
			System.out.println(user1.getUsername());

			entityManager.refresh(user1);
			System.out.println(user1.getUsername());

			entityManager.getTransaction().commit();
		} catch(Exception e) {
			e.printStackTrace();
			//Transaction rollback
		} finally {
			if(entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}
