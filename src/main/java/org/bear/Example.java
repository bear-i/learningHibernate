package org.bear;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.bear.model.one_to_one.join_table.ItemWithJoinTable;
import org.bear.model.one_to_one.join_table.ShipmentWithJoinTable;

public class Example {
	public static void main(String[] args) {

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("HibernateSample");
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		ShipmentWithJoinTable shipment1 = new ShipmentWithJoinTable();
		entityManager.persist(shipment1);

		ItemWithJoinTable item = new ItemWithJoinTable("Some Item");
		ShipmentWithJoinTable shipment2 = new ShipmentWithJoinTable(item);
		entityManager.persist(shipment2);

		entityManager.getTransaction().commit();
	}
}
