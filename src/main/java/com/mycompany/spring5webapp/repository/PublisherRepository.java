package com.mycompany.spring5webapp.repository;

import com.mycompany.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {


}
