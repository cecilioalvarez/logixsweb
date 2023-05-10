package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Sales;
import es.logixs.web.repositories.SalesRepository;
import es.logixs.web.repositories.mysql.mappers.SalesMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SalesRepositoryMySQL implements SalesRepository {

    private final static String sqlUpdate = "update sales set id=?, ownerId=?, clientId=?, code=?, offerId=?, counterOfferId=?, isCounterOffer=? where id=?";

    private final static String sqlInsert = "insert into sales (id,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values (?,?,?,?,?,?,?)";

    private final static String sqlDelete = "delete from sales where id=?";

    private final static String sqlFindAll = "select * from sales";

    private final static String sqlFindOne = "select * from sales where id=?";

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Sales insert(Sales sale) {
        plantilla.update(sqlInsert, sale.getId(),sale.getOwnerId(), sale.getClientId(),sale.getCode(), sale.getOfferId(), sale.getCounterOfferId(), sale.isCounterOffer());
        return sale;
    }
    @Override
    public void delete(Sales sale) {
        plantilla.update(sqlDelete, sale.getId());
    }

    @Override
    public List<Sales> findAll() {
        return plantilla.query(sqlFindAll, new SalesMapper());
    }
    
    @Override
    public Sales findOne(String objectid) {
       return  plantilla.queryForObject(sqlFindOne, new SalesMapper(),objectid);
    }

    @Override
    public void update(Sales sale) {
        plantilla.update(sqlUpdate,sale.getId(), sale.getOwnerId(), sale.getClientId(),sale.getCode(), sale.getOfferId(),sale.getCounterOfferId(), sale.isCounterOffer(), sale.getId());
    }
    @Override
    public void update(Sales sale, Sales oldSale) {
        plantilla.update(sqlUpdate,sale.getId(), sale.getOwnerId(), sale.getClientId(),sale.getCode(), sale.getOfferId(),sale.getCounterOfferId(), sale.isCounterOffer(), oldSale.getId());
    }

}
