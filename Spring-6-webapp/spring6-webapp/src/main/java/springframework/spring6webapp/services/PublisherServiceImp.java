package springframework.spring6webapp.services;

import org.springframework.stereotype.Service;

import springframework.spring6webapp.domain.Publisher;
import springframework.spring6webapp.repositories.PublisherRepository;
import springframework.spring6webapp.services.inter.PublisherService;

@Service
public class PublisherServiceImp implements PublisherService{

    private PublisherRepository publisherRepository;
    

    public PublisherServiceImp(PublisherRepository publisherRepository) {
        this.publisherRepository = publisherRepository;
    }


    @Override
    public Iterable<Publisher> findAll() {
        return publisherRepository.findAll();
    }

}
