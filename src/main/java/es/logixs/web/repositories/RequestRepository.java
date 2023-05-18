package es.logixs.web.repositories;


import es.logixs.web.domain.Request;

import java.util.List;
import java.util.UUID;

public interface RequestRepository {

    Request insert(Request request);
    Request findOne(UUID objectId);
    void delete(Request request);
    List<Request> findAll();
    void update(Request request);
    void update(Request request, Request oldRequest);
}

