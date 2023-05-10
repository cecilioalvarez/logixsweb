package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Products;
import es.logixs.web.repositories.ProductsRepository;
import es.logixs.web.repositories.mysql.mappers.ProductsMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductsRepositoryMySQL implements ProductsRepository {
    @Autowired
    private final static String sqlInsert = "insert into products (id, userId, code, companyId, scientificName, name, category, originCountryIso, quality, descAndSpecs) values (?,?,?,?,?,?,?,?,?,?);";
    private final static String sqlDelete = "delete from products where id=?";
    private final static String sqlFindAll = "select * from products;";
    private final static String sqlFindOne = "select * from products  where id=?;";
    private final static String sqlUpdate = "update products set userId=?, code=?, companyId=?, scientificName=?, name=?, category=?, originCountryIso=?, quality=?, descAndSpecs=? where id=?;";
    @Autowired
    private JdbcTemplate plantilla;
    
    @Override
    public Products insert(Products product) {
        plantilla.update(sqlInsert, product.getId(), product.getUserId(), product.getCode(), product.getCompanyId(), product.getScientificName(), product.getName(), product.getCategory(), product.getOriginCountryIso(), product.getQuality(), product.getDescAndSpecs());
        return product;
    }

    @Override
    public Products findOne(String id) {
        return plantilla.queryForObject(sqlFindOne, Products.class, id);
    }

    @Override
    public List<Products> findAll() {
        return plantilla.query(sqlFindAll, new ProductsMapper());
    }

    @Override
    public void delete(String id) {
       plantilla.update(sqlDelete, id);
    }

    @Override
    public Products update(Products product) {
        plantilla.update(sqlUpdate, product.getUserId(), product.getCode(), product.getCompanyId(), product.getScientificName(), product.getName(), product.getCategory(), product.getOriginCountryIso(), product.getQuality(), product.getDescAndSpecs(), product.getId());
        return product;
    }

    @Override
    public Products update(Products product, Products oldProduct) {
        plantilla.update(sqlUpdate, product.getUserId(), product.getCode(), product.getCompanyId(), product.getScientificName(), product.getName(), product.getCategory(), product.getOriginCountryIso(), product.getQuality(), product.getDescAndSpecs(), oldProduct.getId());
        return product;
    }
}
