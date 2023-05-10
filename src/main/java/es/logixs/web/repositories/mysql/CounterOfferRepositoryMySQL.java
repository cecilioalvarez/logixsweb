package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.CounterOffer;
import es.logixs.web.repositories.CounterOfferRepository;
import es.logixs.web.repositories.mysql.mappers.CounterOfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CounterOfferRepositoryMySQL implements CounterOfferRepository {
    private final static String sqlInsert = "insert into counteroffer (objectId,name,vom,originalPrice,counterOfferPrice,quantity) values(?,?,?,?,?,?)";
    private final static String sqlUpdate = "update counteroffer set name=? ,vom=? ,originalPrice=? ,counterOfferPrice=? ,quantity=? where objectId=?";
    private final static String sqlDelete = "delete from counteroffer where objectId=?";
    private final static String sqlFindAll = "select * from counteroffer;";
    private final static String sqlFindOne = "select * from counteroffer  where objectId=?;";
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public CounterOffer insert(CounterOffer counterOffer) {
        plantilla.update(
                sqlInsert,
                counterOffer.getObjectId(),
                counterOffer.getName(),
                counterOffer.getVom(),
                counterOffer.getOriginalPrice(),
                counterOffer.getCounterOfferPrice(),
                counterOffer.getQuantity()
        );
        return counterOffer;
    }

    @Override
    public void update(CounterOffer counterOffer) {
        plantilla.update(
                sqlUpdate,
                counterOffer.getName(),
                counterOffer.getVom(),
                counterOffer.getOriginalPrice(),
                counterOffer.getCounterOfferPrice(),
                counterOffer.getQuantity(),
                counterOffer.getObjectId()
        );
    }

    @Override
    public void update(CounterOffer counterOffer, CounterOffer oldCounterOffer) {
        plantilla.update(
                sqlUpdate,
                counterOffer.getName(),
                counterOffer.getVom(),
                counterOffer.getOriginalPrice(),
                counterOffer.getCounterOfferPrice(),
                counterOffer.getQuantity(),
                oldCounterOffer.getObjectId()
        );
    }

    @Override
    public void delete(CounterOffer counterOffer) {
        plantilla.update(sqlDelete, counterOffer.getObjectId());
    }

    @Override
    public CounterOffer findOne(String objectId) {
        return plantilla.queryForObject(sqlFindOne, new CounterOfferMapper(), objectId);
    }

    @Override
    public List<CounterOffer> findAll() {
        return plantilla.query(sqlFindAll, new CounterOfferMapper());
    }
}