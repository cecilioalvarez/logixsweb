package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Offer;
import es.logixs.web.repositories.OfferRepository;
import es.logixs.web.repositories.mysql.mappers.OfferMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OfferRepositoryMySQL implements OfferRepository {

    private final static String sqlInsert = "insert into offer (objectId,code,name,description,category) values (?,?,?,?,?)";
    private final static String sqlDelete = "delete from offer where objectId=?";
    private final static String sqlFindAll = "select * from offer";
    private final static String sqlFindOne = "select * from offer where objectId=?";
    private final static String sqlUpdate = "update offer set code=?,name=?,description=?,category=? where objectId=?";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Offer insert(Offer offer) {
        jdbcTemplate.update(sqlInsert, offer.getObjectId(), offer.getCode(), offer.getName(), offer.getDescription(), offer.getCategory());
        return offer;
    }

    @Override
    public Offer update(Offer offer) {
        jdbcTemplate.update(sqlUpdate, offer.getObjectId(), offer.getCode(), offer.getName(), offer.getDescription(), offer.getCategory());
        return offer;
    }

    @Override
    public Offer update(Offer offer, Offer offerOld) {
        jdbcTemplate.update(sqlUpdate, offer.getObjectId(), offer.getCode(), offer.getName(), offer.getDescription(), offer.getCategory(), offerOld.getObjectId());
        return offer;
    }

    @Override
    public void delete(String objectId) {
        jdbcTemplate.update(sqlDelete, objectId);
    }

    @Override
    public Offer findOne(String objectId) {
        return jdbcTemplate.queryForObject(sqlFindOne, new OfferMapper(), objectId);
    }

    @Override
    public List<Offer> findAll() {
        return jdbcTemplate.query(sqlFindAll, new OfferMapper());
    }
}
