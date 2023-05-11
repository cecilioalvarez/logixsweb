package es.logixs.web.repositories.mysql;

import es.logixs.web.domain.Product;
import es.logixs.web.repositories.ProductRepository;
import es.logixs.web.repositories.mysql.mappers.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ProductRepositoryMySQL implements ProductRepository {
    @Autowired
    private final static String sqlInsert = "insert into product (id, userId, code, companyId, scientificName, name, category, originCountryIso, quality, descAndSpecs) values (?,?,?,?,?,?,?,?,?,?);";
    private final static String sqlDelete = "delete from product where id=?;";
    private final static String sqlFindAll = "select * from product;";
    private final static String sqlFindOne = "select * from product where id=?;";
    private final static String sqlUpdate = "update product set userId=?, code=?, companyId=?, scientificName=?, name=?, category=?, originCountryIso=?, quality=?, descAndSpecs=? where objectId=?;";
    @Autowired
    private JdbcTemplate plantilla;
    
    @Override
    public Product insert(Product product) {
        plantilla.update(sqlInsert, product.getId(), product.getUserId(), product.getCode(), product.getCompanyId(), product.getScientificName(), product.getName(), product.getCategory(), product.getOriginCountryIso(), product.getQuality(), product.getDescAndSpecs());
        return product;
    }

    @Override
    public Product findOne(String id) {
        return plantilla.queryForObject(sqlFindOne, new ProductMapper(), id);
    }

    @Override
    public List<Product> findAll() {
        return plantilla.query(sqlFindAll, new ProductMapper());
    }

    @Override
    public void delete(String id) {
       plantilla.update(sqlDelete, id);
    }

    @Override
    public Product update(Product product) {
        plantilla.update(sqlUpdate, product.getUserId(), product.getCode(), product.getCompanyId(), product.getScientificName(), product.getName(), product.getCategory(), product.getOriginCountryIso(), product.getQuality(), product.getDescAndSpecs(), product.getId());
        return product;
    }

    @Override
    public Product update(Product product, Product oldProduct) {
        plantilla.update(sqlUpdate, product.getUserId(), product.getCode(), product.getCompanyId(), product.getScientificName(), product.getName(), product.getCategory(), product.getOriginCountryIso(), product.getQuality(), product.getDescAndSpecs(), oldProduct.getId());
        return product;
    }
}
