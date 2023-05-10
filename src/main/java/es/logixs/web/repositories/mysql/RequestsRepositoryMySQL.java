package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Requests;
import es.logixs.web.repositories.RequestsRepository;
import es.logixs.web.repositories.mysql.mappers.RequestsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestsRepositoryMySQL implements RequestsRepository {

    private final static String sqlInsert = "insert into Requests (code, offerId, ownerId, companyId) values (?,?,?,?);";
    private final static String sqlDelete = "delete from Requests where id=?";
    private final static String sqlFindAll = "select * from Requests;";
    private final static String sqlFindOne = "select * from Requests where id=?;";
    private final static String sqlUpdate = "update companies set id=?, code=?, offerId=?, ownerId=?, companyId=? where id=?";

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Requests insert(Requests request) {
        plantilla.update(sqlInsert, request.getId(),request.getCode(), request.getOfferId(),request.getOwnerId(), request.getCompanyId());
        return request;
    }
    @Override
    public void delete(Requests request) {
        plantilla.update(sqlDelete, request.getId());
    }

    @Override
    public List<Requests> findAll() {
        return plantilla.query(sqlFindAll, new RequestsMapper());
    }
    
    @Override
    public Requests findOne(String objectid) {
       return  plantilla.queryForObject(sqlFindOne, new RequestsMapper(),objectid);
    }

    @Override
    public void update(Requests request) {
        plantilla.update(sqlUpdate,request.getId(), request.getCode(), request.getOfferId(),request.getOwnerId(), request.getCompanyId(),request.getId());
    }
    @Override
    public void update(Requests request, Requests oldRequest) {
        plantilla.update(sqlUpdate,request.getId(), request.getCode(), request.getOfferId(),request.getOwnerId(), request.getCompanyId(), oldRequest.getId());
    }

}
