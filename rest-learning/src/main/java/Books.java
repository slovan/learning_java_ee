import javax.xml.bind.annotation.XmlElement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by Ponomarenko.Volodymyr on 28. 11. 2017.
 */
public class Books extends ArrayList<Book> {

    public Books() {
        super();
    }

    public Books(Collection<? extends Book> c) {
        super(c);
    }

    @XmlElement(name = "book")
    public List<Book> getBooks() {
        return this;
    }

    public void setBooks(List<Book> books) {
        this.addAll(books);
    }
}
