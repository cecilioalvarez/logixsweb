package es.logixs.web.repositories.mysql;

import java.util.Date;
import java.util.List;

import es.logixs.web.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import es.logixs.web.domain.User;
import es.logixs.web.repositories.mysql.mappers.UserMapper;

@Repository
public class UserRepositoryMySQL implements UserRepository {

    private final static String sqlInsert = "insert into user (" +
            "objectId, name, lastName, email, state, avatar, password, prevPasswords, companyId," +
            "invitedBy, role, limitAmount, address, phone, city, zipCode, countryIso, createdAt," +
            "updatedAt) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private final static String sqlFindAll = "select * from user";
    private final static String sqlDelete = "delete from user where objectId=?";
    private final static String sqlFindOne = "select * from user where objectId=?";
    private final static String sqlUpdate = "update user set objectId=?,name=? , lastName=? , email=?," +
            " state=?, avatar=?, password=?, prevPasswords=?, companyId=?,invitedBy=?, role=?, limitAmount=?," +
            " address=?, phone=?, city=?, zipCode=?, countryIso=?, createdAt=?,updatedAt=? where objectId=?";

    @Autowired
    private JdbcTemplate template;

    @Override
    public User insert(User user) {
        template.update(
                sqlInsert,
                user.getObjectId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getState(),
                user.getAvatar(),
                user.getPassword(),
                user.getPrevPasswords(),
                user.getCompanyId(),
                user.getInvitedBy(),
                user.getRole(),
                user.getLimitAmount(),
                user.getAddress(),
                user.getPhone(),
                user.getCity(),
                user.getZipCode(),
                user.getCountryIso(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
        return user;
    }

    @Override
    public void delete(User user) {
        template.update(sqlDelete, user.getObjectId());
    }

    @Override
    public List<User> findAll() {
        return template.query(sqlFindAll, new UserMapper());
    }

    @Override
    public User findOne(String objectId) {
        return template.queryForObject(sqlFindOne, new UserMapper(), objectId);
    }

    @Override
    public void update(User user) {
        template.update(
                sqlUpdate,
                user.getObjectId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getState(),
                user.getAvatar(),
                user.getPassword(),
                user.getPrevPasswords(),
                user.getCompanyId(),
                user.getInvitedBy(),
                user.getRole(),
                user.getLimitAmount(),
                user.getAddress(),
                user.getPhone(),
                user.getCity(),
                user.getZipCode(),
                user.getCountryIso(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                user.getObjectId()
        );

    }

    @Override
    public void update(User user, User oldUser) {
        template.update(
                sqlUpdate,
                user.getObjectId(),
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getState(),
                user.getAvatar(),
                user.getPassword(),
                user.getPrevPasswords(),
                user.getCompanyId(),
                user.getInvitedBy(),
                user.getRole(),
                user.getLimitAmount(),
                user.getAddress(),
                user.getPhone(),
                user.getCity(),
                user.getZipCode(),
                user.getCountryIso(),
                user.getCreatedAt(),
                user.getUpdatedAt(),
                oldUser.getObjectId()
        );
    }
}
