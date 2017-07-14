package main;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entities.Book;

public class Main {

	public static void main(String[] args) {
		
		// Creates an instance of book
		Book book = new Book("Star Wars", "Episode 7", 12.5F, "1-84023-742-2", 354, false);
		
		// Obtains an entity manager and a transaction
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04PU");
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		// Persists the book to the database
		tx.begin();
		em.persist(book);
		tx.commit();
		
		// Closes the entity manager and the factory
		em.close();
		emf.close();
	}

}
