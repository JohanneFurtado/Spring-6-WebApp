package springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springframework.spring6webapp.services.inter.BookService;


@Controller
public class BookController {
    private BookService bookService;
    


    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @RequestMapping("/books")
    public String getBook(Model model){

        model.addAttribute("books", bookService.findAll());
        return "books";
    }
}
