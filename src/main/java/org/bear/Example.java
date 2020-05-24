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
			UserWithSingleColumnConstraint detachedUser = entityManager.find(UserWithSingleColumnConstraint.class, 6L);
			entityManager.detach(detachedUser);
			System.out.println(entityManager.contains(detachedUser));

			detachedUser.setUsername("New username");
			entityManager.merge(detachedUser);

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
