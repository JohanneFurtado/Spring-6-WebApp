package springframework.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        this.publisherRepository = publisherRepository;
    }




    @Override
    public void run(String... args) throws Exception {
        Publisher pb= new Publisher();
        pb.setName("Antonia Rebeiro");
        pb.setAddress("Rua Viana da Mota");
        pb.setCity("Amadora");
        pb.setState("Lisboa");
        pb.setZip("LB");

        Publisher pbSave = publisherRepository.save(pb);
        publisherRepository.save(pbSave);


        System.out.println("In Bootstrap");
        System.out.println("Publisher Count: " + publisherRepository.count());
 
    }
    
}
