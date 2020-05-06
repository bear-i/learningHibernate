package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.many_to_many.many_to_many_with_intermediate_entity.CategorizedItem;
import org.bear.model.many_to_many.many_to_many_with_intermediate_entity.CategoryWithManyToManyWithIntermediateEntity;
import org.bear.model.many_to_many.many_to_many_with_intermediate_entity.ItemWithManyToManyWithIntermediateEntity;
import org.bear.model.many_to_many.simple_many_to_many.CategoryWithManyToMany;
import org.bear.model.many_to_many.simple_many_to_many.ItemWithManyToMany;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		CategoryWithManyToManyWithIntermediateEntity someCategory = new CategoryWithManyToManyWithIntermediateEntity();
		CategoryWithManyToManyWithIntermediateEntity otherCategory = new CategoryWithManyToManyWithIntermediateEntity();
		entityManager.persist(someCategory);
		entityManager.persist(otherCategory);

		ItemWithManyToManyWithIntermediateEntity someItem = new ItemWithManyToManyWithIntermediateEntity();
		ItemWithManyToManyWithIntermediateEntity otherItem = new ItemWithManyToManyWithIntermediateEntity();
		entityManager.persist(someItem);
		entityManager.persist(otherItem);

		CategorizedItem linkOne = new CategorizedItem("johndoe", someCategory, someItem);
		CategorizedItem linkTwo = new CategorizedItem("johndoe", someCategory, otherItem);
		CategorizedItem linkThree = new CategorizedItem("johndoe", otherCategory, someItem);

		entityManager.persist(linkOne);
		entityManager.persist(linkTwo);
		entityManager.persist(linkThree);

		entityManager.getTransaction().commit();
	}
}
