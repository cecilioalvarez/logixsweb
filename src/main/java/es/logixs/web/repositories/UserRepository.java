package es.logixs.web.repositories;

import es.logixs.web.domain.User;

import java.util.List;
import java.util.UUID;

public interface UserRepository {
    User insert(User user);
    void update(User user);
    void update(User user, User oldUser);
    void delete(User user);
    List<User> findAll();
    User findOne(UUID objectId);
}
