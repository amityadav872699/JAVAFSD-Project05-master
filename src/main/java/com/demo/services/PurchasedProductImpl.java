package com.demo.services;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.PurchasedProduct;
import com.demo.repository.PurchasedProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchasedProductImpl implements IPurchasedProductService {

    @Autowired
    private PurchasedProductRepository purchasedproductRepo;

    @Override
    public PurchasedProduct insertPurchasedProductInDB(PurchasedProduct product) {
        return purchasedproductRepo.save(product);
    }

    @Override
    public List<PurchasedProduct> getAllPurchasedProducts() {
        return purchasedproductRepo.findAll();
    }

    @Override
    public void updatePurchasedProductInDB(PurchasedProduct product, Long productId) throws ResourceNotFound {
        PurchasedProduct existingProduct = purchasedproductRepo.findById(productId).get();
        if(product != null) {
            // Update existing Product Details with new Details.
            existingProduct.setCategory(product.getCategory());
            existingProduct.setCompany(product.getCompany());
            existingProduct.setOrigin(product.getOrigin());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setPrice(product.getPrice());
            existingProduct.setTag(product.getTag());
            purchasedproductRepo.save(existingProduct);
        }else {
            throw new ResourceNotFound("Product not found");
        }
    }

    @Override
    public void deletePurchasedProductInDB(Long productId) {
        purchasedproductRepo.deleteById(productId);
    }

    @Override
    public PurchasedProduct getPurchasedProductInDB(Long productId) throws ResourceNotFound {
        return purchasedproductRepo.findById(productId).get();
    }

    @Override
    public List<PurchasedProduct> findByCategory(String category) {
        return purchasedproductRepo.findByCategory(category);
    }

    @Override
    public List<PurchasedProduct> findByCustomerId(Long id) {
        return purchasedproductRepo.findByCustomerId(id);
    }


}
