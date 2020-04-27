package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.many_to_many.CategoryWithManyToMany;
import org.bear.model.many_to_many.ItemWithManyToMany;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		CategoryWithManyToMany category1 = new CategoryWithManyToMany();
		CategoryWithManyToMany category2 = new CategoryWithManyToMany();

		ItemWithManyToMany item1 = new ItemWithManyToMany();
		ItemWithManyToMany item2 = new ItemWithManyToMany();

		category1.getItems().add(item1);
		item1.getCategories().add(category1);

		category2.getItems().add(item2);
		item2.getCategories().add(category2);

		entityManager.persist(category1);
		entityManager.persist(category2);

		entityManager.getTransaction().commit();
	}
}
