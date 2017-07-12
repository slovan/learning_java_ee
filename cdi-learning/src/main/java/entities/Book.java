package entities;

public class Book {//the book POJO
	private String title;
	private Float price;
	private String description;
	private String isbn;
	private String issn;

	public Book(String title, Float price, String description) {
		this.title = title;
		this.price = price;
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getIssn() {
		return issn;
	}

	public void setIssn(String issn) {
		this.issn = issn;
	}

	@Override
	public String toString() {
		return "Book [title=\'" + title + "\', price=" + price + ", description=\'" + description + "\', isbn=\'" + isbn
				+ "\', issn=\'" + issn + "\']";
	}

	
}
