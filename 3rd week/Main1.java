public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}
public class BookRepository {
    public void save(Book book) {
        System.out.println("Saving book to database...");
        book.display();
    }
}
 public class BookService {
    private Book book;

    public BookService(Book book) {
        this.book = book;
    }

    public void showBook() {
        book.display();
    }
}
public class Main1 {
    public static void main(String[] args) {
        Book book = new Book("Core Java", "Kathy Sierra");
        BookService service = new BookService(book);
        service.showBook();
    }
}

    