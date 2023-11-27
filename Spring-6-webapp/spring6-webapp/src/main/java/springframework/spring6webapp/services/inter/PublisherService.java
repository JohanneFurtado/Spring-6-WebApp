package springframework.spring6webapp.services.inter;

import springframework.spring6webapp.domain.Publisher;

public interface PublisherService {
    public Iterable<Publisher> findAll();
}
