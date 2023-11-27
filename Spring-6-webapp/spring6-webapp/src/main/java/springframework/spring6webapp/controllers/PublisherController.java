package springframework.spring6webapp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import springframework.spring6webapp.services.inter.PublisherService;


@Controller
public class PublisherController {
    private PublisherService publisherService;
    


    public PublisherController(PublisherService publisherService) {
        this.publisherService = publisherService;
    }



    @RequestMapping("/publishers")
    public String getPublisher(Model model){

        model.addAttribute("publishers", publisherService.findAll());
        return "publishers";
    }
}
