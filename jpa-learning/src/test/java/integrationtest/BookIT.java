package integrationtest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entities.Book;

public class BookIT {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("chapter04TestPU");
	private EntityManager em;
	private EntityTransaction tx;

	@Before
	public void initEntityManager() throws Exception {
		em = emf.createEntityManager();
		tx = em.getTransaction();
	}

	@After
	public void closeEntityManager() throws Exception {
		if (em != null)
			em.close();
	}

	@Test
	public void shouldFindJavaEE7Book() throws Exception {
		Book book;
		//book = em.createNamedQuery("findAllBooks", Book.class).getResultList().get(0);
		book = em.find(Book.class, 1001L);
		assertNotNull("Book schould be found", book);
		assertEquals("Beginning Java EE 7", book.getTitle());
	}

	@Test
	public void shouldCreateH2G2Book() throws Exception {
		// Creates an instance of book
		Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);
		// Persists the book to the database
		tx.begin();
		em.persist(book);
		tx.commit();
		assertNotNull("ID should not be null", book.getId());
		// Retrieves all the books from the database
		book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
		assertEquals("The Hitchhiker's Guide to the Galaxy", book.getDescription());
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldRaiseConstraintViolationCauseNullTitle() {
		Book book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);
		em.persist(book);
	}
}
