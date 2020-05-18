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

			UserWithSingleColumnConstraint user = new UserWithSingleColumnConstraint("username");
			entityManager.persist(user);

			entityManager.getTransaction().commit();
		} catch(Exception e) {
			//Transaction rollback
		} finally {
			if(entityManager != null && entityManager.isOpen()) {
				entityManager.close();
			}
		}
	}
}
