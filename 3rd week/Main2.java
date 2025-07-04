import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

class Book {
    private String title;
    private String author;

    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }

    public void display() {
        System.out.println("Book: " + title + " by " + author);
    }
}

class BookRepository {
    public void save(Book book) {
        System.out.println("Saving book to database...");
        book.display();
    }
}

class BookService {
    private BookRepository repository;

    public void setRepository(BookRepository repository) {
        this.repository = repository;
    }

    public void addBook(Book book) {
        repository.save(book);
    }
}

public class Main2 {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService service = (BookService) context.getBean("bookService");

        Book book = new Book();
        book.setTitle("Spring Core");
        book.setAuthor("Rod Johnson");

        service.addBook(book);
    }
}
