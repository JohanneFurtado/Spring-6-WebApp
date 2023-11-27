package springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import springframework.spring6webapp.domain.Book;
import springframework.spring6webapp.repositories.BookRepository;
import springframework.spring6webapp.services.inter.BookService;

@Service
public class BookServiceImp implements BookService{

    private BookRepository bookRepository;
    

    public BookServiceImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }

}
