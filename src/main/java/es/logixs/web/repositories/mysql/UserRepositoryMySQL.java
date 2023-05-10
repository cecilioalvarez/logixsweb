package es.logixs.web.repositories.mysql;

import java.util.List;

import es.logixs.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.UserRepository;
import es.logixs.web.repositories.mysql.mappers.UserMapper;

@Repository
public class UserRepositoryMySQL implements UserRepository {

    private final static String sqlInsert = "insert into user (objectid,name,lastName,email) values (?,?,?,?)";
    private final static String sqlFindAll = "select * from user";
    private final static String sqlDelete = "delete from user where objectid=?";
    private final static String sqlFindOne = "select * from user where objectid=?";
    private final static String sqlUpdate = "update user set objectId=?,name=? , lastName=? , email=? where objectid=?";

    @Autowired
    private JdbcTemplate template;

    @Override
    public User insert(User user) {
        template.update(sqlInsert, user.getObjectid(),user.getName(), user.getLastName(),user.getEmail());
        return user;
    }
    @Override
    public void delete(User user) {
        template.update(sqlDelete, user.getObjectid());
    }

    @Override
    public List<User> findAll() {
        return template.query(sqlFindAll, new UserMapper());
    }

    @Override
    public User findOne(String objectid) {

        return  template.queryForObject(sqlFindOne, new UserMapper(),objectid);
    }
    @Override
    public void update(User user) {

        template.update(sqlUpdate,user.getObjectid(), user.getName(), user.getLastName(),user.getEmail(),user.getObjectid());

    }
    @Override
    public void update(User user, User oldUser) {

        template.update(sqlUpdate,user.getObjectid(), user.getName(), user.getLastName(),user.getEmail(),oldUser.getObjectid());
    }

}
