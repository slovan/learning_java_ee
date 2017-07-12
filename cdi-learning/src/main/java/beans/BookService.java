package beans;

import javax.inject.Inject;
import javax.transaction.Transactional;

import annotations.interceptor_binding.Loggable;
import annotations.qualifiers.EightDigits;
import annotations.qualifiers.ThirteenDigits;
import beans.interfaces.NumberGenerator;
import entities.Book;


@Transactional
@Loggable
public class BookService {
	
	@Inject
	@ThirteenDigits
	private NumberGenerator isbnGenerator;
	
	@Inject 
	@EightDigits
	private NumberGenerator issnGenerator;

	public Book createBook(String title, Float price, String description) {
		Book book = new Book(title, price, description);
		book.setIsbn(isbnGenerator.generateNumber());
		book.setIssn(issnGenerator.generateNumber());
		return book;
	}
}
