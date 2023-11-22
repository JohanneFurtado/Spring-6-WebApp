package springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;

@Component
public class BootstrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }




    @Override
    public void run(String... args) throws Exception {
        Author luis= new Author();
        luis.setFirstName("Luis");
        luis.setLastName("Camoes");
        
        Book pes = new Book();
        pes.setTitle("Contos e fadas");
        pes.setIsbn("1234367");

        Author luisSave= authorRepository.save(luis);
        Book pesSave = bookRepository.save(pes);

        Author fer = new Author();
        fer.setFirstName("Fernando");
        fer.setLastName("Pessoa");

        Book cr = new Book();
        cr.setTitle("Cronicas");
        cr.setIsbn("9767924");

        Author ferSave= authorRepository.save(fer);
        Book crSave = bookRepository.save(cr);

        luisSave.getBooks().add(pesSave);
        ferSave.getBooks().add(crSave);

        authorRepository.save(luisSave);
        authorRepository.save(ferSave);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
 
    }
    
}
