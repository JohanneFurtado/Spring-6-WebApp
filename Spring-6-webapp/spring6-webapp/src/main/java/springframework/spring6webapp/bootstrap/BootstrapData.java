package springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.domain.Publisher;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.repositories.BookRepository;
import springframework.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    
    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository=publisherRepository;
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
        pesSave.getAuthors().add(luisSave);
        crSave.getAuthors().add(ferSave);

        Publisher pb= new Publisher();
        pb.setName("Antonia Rebeiro");
        pb.setAddress("Rua Viana da Mota");
        pb.setCity("Amadora");
        pb.setState("Lisboa");
        pb.setZip("LB");

        Publisher pbSave = publisherRepository.save(pb);

        pesSave.setPublisher(pbSave);
        crSave.setPublisher(pbSave);

        authorRepository.save(luisSave);
        authorRepository.save(ferSave);

        bookRepository.save(pesSave);
        bookRepository.save(crSave);

        System.out.println("In Bootstrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Pubisher Count: " + publisherRepository.count());
 
    }
    
}
