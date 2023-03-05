package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Product;

import java.util.List;

public interface IProductService {

    // CRUD Operations
    public Product insertProductInDB(Product product);
    public List<Product> getAllProducts();
    public void updateProductInDB(Product product,Long productId) throws ResourceNotFound;
    public void deleteProductInDB(Long productId);
    public Product getProductInDB(Long productId) throws ResourceNotFound;

}
