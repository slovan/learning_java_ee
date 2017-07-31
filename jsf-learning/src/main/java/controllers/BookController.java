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
		FacesContext ctx = FacesContext.getCurrentInstance();
		if (book.getTitle() == null || "".equals(book.getTitle())) {
			ctx.addMessage("bookForm:title", new FacesMessage(FacesMessage.SEVERITY_WARN, "Wrong title",
					"You should enter a title for the book"));
		}

		if (ctx.getMessageList().size() != 0)
			return null;

		try {
			bookEJB.createBook(book);
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,
					"Book created", "The book" + book.getTitle() + " has been created with id=" + book.getId()));
			return "newBook.xhtml";
		} catch (Exception e) {
			ctx.addMessage(null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Book hasn't been created", e.getMessage()));
		}
		return null;
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
