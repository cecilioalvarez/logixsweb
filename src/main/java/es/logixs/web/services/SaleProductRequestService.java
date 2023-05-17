package es.logixs.web.services;

import es.logixs.web.domain.Product;
import es.logixs.web.domain.Request;
import es.logixs.web.domain.Sale;
import es.logixs.web.repositories.ProductRepository;
import es.logixs.web.repositories.RequestRepository;
import es.logixs.web.repositories.SaleRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

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
    public Sale insertSale(Sale sale) {
        return saleRepository.insert(sale);
    }

    public List<Sale> insertSalesList(List<Sale> saleList) {
        for(Sale sale : saleList){
            saleRepository.insert(sale);
        }
        return saleList;
    }

    public void updateSale(Sale sale) {
        saleRepository.update(sale);
    }

    public Sale findOneSale(String objectId) {
        return saleRepository.findOne(objectId);
    }

    public List<Sale> findAllSales() {
        return saleRepository.findAll();
    }

    public void deleteSale(String objectId) {
        saleRepository.delete(objectId);
    }

    // Products
    public Product insertProduct(Product product) {
        return productRepository.insert(product);
    }

    public List<Product> insertProductsList(List<Product> productList) {
        for(Product product : productList){
            productRepository.insert(product);
        }
        return productList;
    }

    public Product findOneProduct(String objectId) {
        return productRepository.findOne(objectId);
    }

    public List<Product> findAllProducts() {
        return productRepository.findAll();
    }

    public void deleteProduct(String objectId) {
        productRepository.delete(objectId);
    }

    // Requests
    public Request insertRequest(Request request) {
        return requestRepository.insert(request);
    }

    public List<Request> insertRequestsList(List<Request> requestList) {
        for(Request request : requestList){
            requestRepository.insert(request);
        }
        return requestList;
    }

    public Request findOneRequest(UUID objectId) {
        return requestRepository.findOne(objectId);
    }

    public List<Request> findAllRequests() {
        return requestRepository.findAll();
    }

    public void deleteRequest(Request request) {
        requestRepository.delete(request);
    }

    public void updateRequest(Request request, UUID objectId) {
        Request requestOld= requestRepository.findOne(objectId);
        requestRepository.update(request,requestOld);
    }

    public void updateProduct(Product product, String objectId) {
        Product productOld= productRepository.findOne(objectId);
        productRepository.update(product,productOld);
    }

    public void updateSale(Sale sale, String objectId) {
        Sale saleOld= saleRepository.findOne(objectId);
        saleRepository.update(sale,saleOld);
    }
}