package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.CounterOffers;
import es.logixs.web.repositories.CounterOffersRepository;
import es.logixs.web.repositories.mysql.mappers.CounterOffersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class CounterOffersRepositoryMySQL implements CounterOffersRepository {
    private final static String sqlInsert = "insert into counter_offers (objectId,name,vom,originalPrice,counterOfferPrice,quantity) values(?,?,?,?,?,?)";
    private final static String sqlUpdate = "update counter_offers set name=? ,vom=? ,originalPrice=? ,counterOfferPrice=? ,quantity=? where objectId=?";
    private final static String sqlDelete = "delete from counter_offers where objectId=?";
    private final static String sqlFindAll = "select * from counter_offers;";
    private final static String sqlFindOne = "select * from counter_offers  where objectId=?;";
    @Autowired
    private JdbcTemplate plantilla;

    @Override
    public CounterOffers insert(CounterOffers counterOffer) {
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
    public void update(CounterOffers counterOffer) {
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
    public void update(CounterOffers counterOffer,CounterOffers oldCounterOffer) {
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
    public void delete(CounterOffers counterOffer) {
        plantilla.update(sqlDelete, counterOffer.getObjectId());
    }

    @Override
    public CounterOffers findOne(String objectId) {
        return plantilla.queryForObject(sqlFindOne, new CounterOffersMapper(), objectId);
    }

    @Override
    public List<CounterOffers> findAll() {
        return plantilla.query(sqlFindAll, new CounterOffersMapper());
    }
}