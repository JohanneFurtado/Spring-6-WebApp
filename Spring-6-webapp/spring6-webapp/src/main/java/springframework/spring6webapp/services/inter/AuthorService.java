package springframework.spring6webapp.services.inter;

import springframework.spring6webapp.domain.Author;

public interface AuthorService {
    public Iterable<Author> findAll();
}
