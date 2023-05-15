package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Request;
import es.logixs.web.repositories.RequestRepository;
import es.logixs.web.repositories.mysql.mappers.RequestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RequestRepositoryMySQL implements RequestRepository {

    private final static String sqlInsert = "insert into request (objectId, code, offerId, ownerId, companyId) values (?,?,?,?,?);";
    private final static String sqlDelete = "delete from request where objectId=?";
    private final static String sqlFindAll = "select * from request;";
    private final static String sqlFindOne = "select * from request where objectId=?;";
    private final static String sqlUpdate = "update request set objectId=?, code=?, offerId=?, ownerId=?, companyId=? where objectId=?";

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Request insert(Request request) {
        plantilla.update(sqlInsert, request.getObjectId(),request.getCode(), request.getOfferId(),request.getOwnerId(), request.getCompanyId());
        return request;
    }
    @Override
    public void delete(String objectId) {
        plantilla.update(sqlDelete, objectId);
    }

    @Override
    public List<Request> findAll() {
        return plantilla.query(sqlFindAll, new RequestMapper());
    }
    
    @Override
    public Request findOne(String objectId) {
       return  plantilla.queryForObject(sqlFindOne, new RequestMapper(),objectId);
    }

    @Override
    public void update(Request request) {
        plantilla.update(sqlUpdate,request.getObjectId(), request.getCode(), request.getOfferId(),request.getOwnerId(), request.getCompanyId(),request.getObjectId());
    }
    @Override
    public void update(Request request, Request oldRequest) {
        plantilla.update(sqlUpdate,request.getObjectId(), request.getCode(), request.getOfferId(),request.getOwnerId(), request.getCompanyId(), oldRequest.getObjectId());
    }

}
