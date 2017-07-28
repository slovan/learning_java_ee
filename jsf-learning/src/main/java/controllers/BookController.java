package controllers;

import javax.faces.application.FacesMessage;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import models.Book;
import services.BookEJB;

@Named
@RequestScoped
public class BookController {

	@Inject
	private BookEJB bookEJB;
	private Book book = new Book();

	public String doCreateBook() {
		bookEJB.createBook(book);
		FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
				"The book" + book.getTitle() + " has been created with id=" + book.getId()));
		return "newBook.xhtml";
	}

	public void doFindBookById() {
		book = bookEJB.findBookById(book.getId());
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}
}
