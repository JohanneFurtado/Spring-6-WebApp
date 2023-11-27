package springframework.spring6webapp.services.inter;

import springframework.spring6webapp.domain.Book;

public interface BookService {
    public Iterable<Book> findAll();
}
