package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Request;
import es.logixs.web.repositories.RequestRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;
import java.util.UUID;

@Repository
public class RequestRepositoryMySQL implements RequestRepository {

    @PersistenceContext
    EntityManager em;


    @Override
    @Transactional
    public Request insert(Request request) {
        em.persist(request);
        return request;
    }
    @Override
    @Transactional
    public void delete(Request request) {
        Request requestToDelete = em.find(Request.class, request.getObjectId());
        em.remove(requestToDelete);
    }

    @Override
    public List<Request> findAll() {
        return em.createQuery("select r from Request r", Request.class).getResultList();
    }
    
    @Override
    public Request findOne(UUID objectId) {
        return em.find(Request.class, objectId);
    }

    @Override
    public void update(Request request) {
        em.merge(request);
    }
    @Override
    public void update(Request request, Request oldRequest) {

    }

}
