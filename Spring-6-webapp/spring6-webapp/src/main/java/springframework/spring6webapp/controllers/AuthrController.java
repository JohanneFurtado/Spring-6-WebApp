package springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springframework.spring6webapp.services.inter.AuthorService;


@Controller
public class AuthrController {
    private AuthorService authorService;
    


    public AuthrController(AuthorService authorService) {
        this.authorService = authorService;
    }



    @RequestMapping("/authors")
    public String getAuthor(Model model){

        model.addAttribute("authors", authorService.findAll());
        return "authors";
    }
}
