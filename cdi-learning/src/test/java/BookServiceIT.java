import static org.junit.Assert.assertTrue;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import beans.BookService;
import entities.Book;

public class BookServiceIT {
	@Test
	public void shouldCheckNumberIsMOCK() {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		BookService bookService = container.instance().select(BookService.class).get();
		
		Book book = bookService.createBook("Thinking in JAVA", 40.5f, "First book for programming");
		
		assertTrue(book.getNumber().startsWith("MOCK"));
		
		weld.shutdown();
	}
}
