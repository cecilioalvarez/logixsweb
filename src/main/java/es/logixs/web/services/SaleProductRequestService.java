package es.logixs.web.services;

import es.logixs.web.domain.Product;
import es.logixs.web.domain.Request;
import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.ProductRepository;
import es.logixs.web.repositories.RequestRepository;
import es.logixs.web.repositories.SaleRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SaleProductRequestService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final RequestRepository requestRepository;

    public SaleProductRequestService(SaleRepository saleRepository, ProductRepository productRepository,
                                     RequestRepository requestRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.requestRepository = requestRepository;
    }

    // Sales
    public Sale insertSales(Sale sale) {
        return saleRepository.insert(sale);
    }

    public List<Sale> insertSalesList(List<Sale> saleList) {
        for(Sale sale : saleList){
            saleRepository.insert(sale);
        }
        return saleList;
    }

    public void updateSales(Sale sale) {
        saleRepository.update(sale);
    }

    public Sale findOneSales(String id) {
        return saleRepository.findOne(id);
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public void deleteSales(Sale sale) {
        saleRepository.delete(sale);
    }

    // Products
    public Product insertProducts(Product product) {
        return productRepository.insert(product);
    }

    public List<Product> insertProductsList(List<Product> productList) {
        for(Product product : productList){
            productRepository.insert(product);
        }
        return productList;
    }

    public Product findOneProducts(String id) {
        return productRepository.findOne(id);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProducts(String id) {
        productRepository.delete(id);
    }

    // Requests
    public Request insertRequests(Request request) {
        return requestRepository.insert(request);
    }

    public List<Request> insertRequestsList(List<Request> requestList) {
        for(Request request : requestList){
            requestRepository.insert(request);
        }
        return requestList;
    }

    public Request findOneRequests(String id) {
        return requestRepository.findOne(id);
    }

    public List<Request> findAllRequests() {
        return requestRepository.findAll();
    }

    public void deleteRequests(Request request) {
        requestRepository.delete(request);
    }

    public void updateRequests(Request request, String objectId) {
        Request requestOld= requestRepository.findOne(objectId);
        requestRepository.update(request,requestOld);
    }

    public void updateProducts(Product product, String objectId) {
        Product productOld= productRepository.findOne(objectId);
        productRepository.update(product,productOld);
    }

    public void updateSales(Sale sale, String objectId) {
        Sale saleOld= saleRepository.findOne(objectId);
        saleRepository.update(sale,saleOld);
    }
}