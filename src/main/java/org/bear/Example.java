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

			UserWithSingleColumnConstraint user = entityManager.find(UserWithSingleColumnConstraint.class, 1L);
			entityManager.remove(user);
			System.out.println(entityManager.contains(user));

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
