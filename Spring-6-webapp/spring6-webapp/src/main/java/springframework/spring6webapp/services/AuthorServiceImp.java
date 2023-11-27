package springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import springframework.spring6webapp.domain.Author;
import springframework.spring6webapp.repositories.AuthorRepository;
import springframework.spring6webapp.services.inter.AuthorService;

@Service
public class AuthorServiceImp implements AuthorService{

    private AuthorRepository authorRepository;
    

    public AuthorServiceImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }


    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }

}
