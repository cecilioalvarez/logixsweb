package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.UserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.UUID;

@Repository
public class UserRepositoryMySQL implements UserRepository {
    @PersistenceContext
    EntityManager em;

    @Override
    @Transactional
    public User insert(User user) {
        em.persist(user);
        return user;
    }

    @Override
    @Transactional
    public void update(User user) {

        em.merge(user);
    }

    @Override
    public void update(User user, User oldUser) {


    }

    @Override
    @Transactional
    public void delete(User user) {
        User userToDelete = em.find(User.class, user.getObjectId());
        em.remove(userToDelete);
    }

    @Override
    public List<User> findAll() {
        return em.createQuery("select u from User u ", User.class).getResultList();
    }

    @Override
    public User findOne(UUID objectId) {
        return em.find(User.class, objectId);
    }
}
