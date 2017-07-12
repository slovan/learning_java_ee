import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import beans.BookService;
import entities.Book;

public class Main {

	public static void main(String[] args) {
		Weld weld = new Weld();
		WeldContainer container = weld.initialize();
		
		BookService bookService = container.instance().select(BookService.class).get();
		
		Book book = bookService.createBook("Thinking in JAVA", 40.5f, "First book for programming");
		
		System.out.println(book);
		
		weld.shutdown();
	}

}
