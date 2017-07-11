package beans;

import javax.inject.Inject;

import annotations.interceptor_binding.Loggable;
import annotations.qualifiers.ThirteenDigits;
import beans.interfaces.NumberGenerator;
import entities.Book;

@Loggable
public class BookService {
	
	@Inject @ThirteenDigits
	private NumberGenerator numberGenerator;

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setNumber(numberGenerator.generateNumber());
		return book;
	}
}
