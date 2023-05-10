package es.logixs.web.repositories;


import es.logixs.web.domain.Companies;
import es.logixs.web.domain.Requests;

import java.util.List;

public interface RequestsRepository {

    Requests insert(Requests requests);
    Requests findOne(String id);

    void delete(Requests request);

    List<Requests> findAll();

    void update(Requests request);

    void update(Requests request, Requests oldRequest);
}

