package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.many_to_many.ternary_many_to_many.CategoryWithTernaryManyToMany;
import org.bear.model.many_to_many.ternary_many_to_many.EmbeddableCategorizedItem;
import org.bear.model.many_to_many.ternary_many_to_many.ItemWithTernaryManyToMany;
import org.bear.model.many_to_many.ternary_many_to_many.UserWithTernaryManytoMany;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		CategoryWithTernaryManyToMany someCategory = new CategoryWithTernaryManyToMany();
		CategoryWithTernaryManyToMany otherCategory = new CategoryWithTernaryManyToMany();
		entityManager.persist(someCategory);
		entityManager.persist(otherCategory);

		ItemWithTernaryManyToMany someItem = new ItemWithTernaryManyToMany();
		ItemWithTernaryManyToMany otherItem = new ItemWithTernaryManyToMany();
		entityManager.persist(someItem);
		entityManager.persist(otherItem);

		UserWithTernaryManytoMany someUser = new UserWithTernaryManytoMany();
		entityManager.persist(someUser);

		EmbeddableCategorizedItem linkOne = new EmbeddableCategorizedItem(someItem, someUser);
		someCategory.getCategorizedItems().add(linkOne);
		EmbeddableCategorizedItem linkTwo = new EmbeddableCategorizedItem(otherItem, someUser);
		someCategory.getCategorizedItems().add(linkTwo);
		EmbeddableCategorizedItem linkThree = new EmbeddableCategorizedItem(someItem, someUser);
		otherCategory.getCategorizedItems().add(linkThree);

		entityManager.getTransaction().commit();
	}
}
