package guru.springframework.spring5web.Bootsrap;

import guru.springframework.spring5web.domain.Author;
import guru.springframework.spring5web.domain.Book;
import guru.springframework.spring5web.domain.Publisher;
import guru.springframework.spring5web.repository.AuthorRepository;
import guru.springframework.spring5web.repository.BookRepository;
import guru.springframework.spring5web.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootsrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootsrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository =publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("started in bootsrap");

        Publisher publisher = new Publisher();
        publisher.setName("SFG Publishing");
        publisher.setCity("st Petersburg");
        publisher.setState("fl");

        publisherRepository.save(publisher);

        System.out.println("Publisher count: "+ publisherRepository.count());


        Author eric = new Author("eric","evans");
        Book ddd = new Book("domain driven design","123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);

        ddd.setPublisher(publisher);
        publisher.getBook().add(ddd);

        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("rod","johnson");
        Book noEJB = new Book("J2EE Development without EJB","3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);


        noEJB.setPublisher(publisher);
        publisher.getBook().add(noEJB);
        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);
        System.out.println("number of books: "+bookRepository.count());
        System.out.println("publisher number of books:" +publisher.getBook().size());
    }
}
