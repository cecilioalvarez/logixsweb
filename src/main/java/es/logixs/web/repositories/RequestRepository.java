package es.logixs.web.repositories;


import es.logixs.web.domain.Request;

import java.util.List;

public interface RequestRepository {

    Request insert(Request request);
    Request findOne(String objectId);

    void delete(String objectId);

    List<Request> findAll();

    void update(Request request);

    void update(Request request, Request oldRequest);
}

