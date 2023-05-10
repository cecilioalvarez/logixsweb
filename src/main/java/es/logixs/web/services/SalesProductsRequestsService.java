package es.logixs.web.services;

import es.logixs.web.domain.Companies;
import es.logixs.web.domain.Products;
import es.logixs.web.domain.Requests;
import es.logixs.web.domain.Sales;
import es.logixs.web.repositories.ProductsRepository;
import es.logixs.web.repositories.RequestsRepository;
import es.logixs.web.repositories.SalesRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SalesProductsRequestsService {
    private SalesRepository salesRepository;
    private ProductsRepository productsRepository;
    private RequestsRepository requestsRepository;

    public SalesProductsRequestsService(SalesRepository salesRepository, ProductsRepository productsRepository,
                                        RequestsRepository requestsRepository) {
        this.salesRepository = salesRepository;
        this.productsRepository = productsRepository;
        this.requestsRepository = requestsRepository;
    }

    // Sales
    public Sales insertSales(Sales sales) {
        return salesRepository.insert(sales);
    }

    public List<Sales> insertSalesList(List<Sales> salesList) {
        for(Sales sales : salesList){
            salesRepository.insert(sales);
        }
        return salesList;
    }

    public void updateSales(Sales sales) {
        salesRepository.update(sales);
    }

    public Sales findOneSales(String id) {
        return salesRepository.findOne(id);
    }

    public List<Sales> findAllSales() {
        return salesRepository.findAll();
    }

    public void deleteSales(Sales sales) {
        salesRepository.delete(sales);
    }

    // Products
    public Products insertProducts(Products products) {
        return productsRepository.insert(products);
    }

    public List<Products> insertProductsList(List<Products> productsList) {
        for(Products products : productsList){
            productsRepository.insert(products);
        }
        return productsList;
    }

    public Products findOneProducts(String id) {
        return productsRepository.findOne(id);
    }

    public List<Products> findAllProducts() {
        return productsRepository.findAll();
    }

    public void deleteProducts(String id) {
        productsRepository.delete(id);
    }

    // Requests
    public Requests insertRequests(Requests requests) {
        return requestsRepository.insert(requests);
    }

    public List<Requests> insertRequestsList(List<Requests> requestsList) {
        for(Requests requests : requestsList){
            requestsRepository.insert(requests);
        }
        return requestsList;
    }

    public Requests findOneRequests(String id) {
        return requestsRepository.findOne(id);
    }

    public List<Requests> findAllRequests() {
        return requestsRepository.findAll();
    }

    public void deleteRequests(Requests requests) {
        requestsRepository.delete(requests);
    }

    public void updateRequests(Requests requests,String objectId) {
        Requests requestOld= requestsRepository.findOne(objectId);
        requestsRepository.update(requests,requestOld);
    }

    public void updateProducts(Products product, String objectId) {
        Products productOld= productsRepository.findOne(objectId);
        productsRepository.update(product,productOld);
    }

    public void updateSales(Sales sale, String objectId) {
        Sales saleOld= salesRepository.findOne(objectId);
        salesRepository.update(sale,saleOld);
    }
}