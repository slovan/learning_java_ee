package services;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

import models.Book;

@Named
@Stateless
public class BookEJB {
	
	@Inject
	private EntityManager em;

	public Book createBook(Book book) {
		em.persist(book);
		return book;
	}

	public List<Book> findAllBooks() {
		return em.createNamedQuery("findAllBooks", Book.class).getResultList();
	}

	public Book findBookById(Long id) {
		return em.find(Book.class, id);
	}
}
