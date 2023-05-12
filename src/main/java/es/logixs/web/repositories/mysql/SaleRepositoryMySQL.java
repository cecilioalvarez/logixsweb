package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.SaleRepository;
import es.logixs.web.repositories.mysql.mappers.SaleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SaleRepositoryMySQL implements SaleRepository {

    private final static String sqlUpdate = "update sale set objectId=?, ownerId=?, clientId=?, code=?, offerId=?, counterOfferId=?, isCounterOffer=? where objectId=?";

    private final static String sqlInsert = "insert into sale (objectId,ownerId,clientId,code,offerId,counterOfferId,isCounterOffer) values (?,?,?,?,?,?,?)";

    private final static String sqlDelete = "delete from sale where objectId=?";

    private final static String sqlFindAll = "select * from sale";

    private final static String sqlFindOne = "select * from sale where objectId=?";

    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public Sale insert(Sale sale) {
        plantilla.update(sqlInsert, sale.getObjectId(),sale.getOwnerId(), sale.getClientId(),sale.getCode(), sale.getOfferId(), sale.getCounterOfferId(), sale.isCounterOffer());
        return sale;
    }
    @Override
    public void delete(Sale sale) {
        plantilla.update(sqlDelete, sale.getObjectId());
    }

    @Override
    public List<Sale> findAll() {
        return plantilla.query(sqlFindAll, new SaleMapper());
    }

    @Override
    public Sale findOne(String objectId) {
       return  plantilla.queryForObject(sqlFindOne, new SaleMapper(),objectId);
    }

    @Override
    public void update(Sale sale) {
        plantilla.update(sqlUpdate,sale.getObjectId(), sale.getOwnerId(), sale.getClientId(),sale.getCode(), sale.getOfferId(),sale.getCounterOfferId(), sale.isCounterOffer(), sale.getObjectId());
    }
    @Override
    public void update(Sale sale, Sale oldSale) {
        plantilla.update(sqlUpdate,sale.getObjectId(), sale.getOwnerId(), sale.getClientId(),sale.getCode(), sale.getOfferId(),sale.getCounterOfferId(), sale.isCounterOffer(), oldSale.getObjectId());
    }

}
