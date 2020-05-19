package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnitUtil;

import org.bear.model.constraints.single_column_constraint.UserWithSingleColumnConstraint;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = null;

		try {
			entityManager = entityManagerFactory.createEntityManager();
			entityManager.getTransaction().begin();

			UserWithSingleColumnConstraint user = entityManager.getReference(UserWithSingleColumnConstraint.class, 1L);
			PersistenceUnitUtil persistenceUnitUtil = entityManagerFactory.getPersistenceUnitUtil();
			System.out.println(persistenceUnitUtil.isLoaded(user));

			System.out.println(user.getUsername());
			System.out.println(persistenceUnitUtil.isLoaded(user));

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
