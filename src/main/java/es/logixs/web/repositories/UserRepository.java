package es.logixs.web.repositories;

import es.logixs.web.domain.User;

import java.util.List;

public interface UserRepository {
    User insert(User user);
    void update(User user);
    void update(User user, User oldUser);
    void delete(User user);
    List<User> findAll();
    User findOne(String objectId);
}
