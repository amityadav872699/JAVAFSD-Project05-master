package com.demo.controllers;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.PurchasedProduct;
import com.demo.services.IPurchasedProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping("/purchased")
public class PurchasedProductController {

    @Autowired
    private IPurchasedProductService purchasedproductService;

    @PostMapping("/insertpurchasedproduct")
    public PurchasedProduct insertProduct(@RequestBody PurchasedProduct newProduct)	{
        return purchasedproductService.insertPurchasedProductInDB(newProduct);
    }

    @GetMapping("/getallpurchasedproducts")
    public List<PurchasedProduct> getAllPurchasedProducts(){
        return purchasedproductService.getAllPurchasedProducts();
    }

    @GetMapping("/getpurchasedproduct/{productid}")
    public PurchasedProduct getProduct(@PathVariable("productid") Long productId) throws ResourceNotFound {
        return purchasedproductService.getPurchasedProductInDB(productId);
    }

    @DeleteMapping("/deletepurchasedproduct/{productid}")
    public void deletePurchasedProduct(@PathVariable("productid") Long productId) {
        purchasedproductService.deletePurchasedProductInDB(productId);
    }

    @PutMapping("/updatepurchasedproductbyid/{productid}")
    public void updatePurchasedProduct(@PathVariable("productid") Long productId, @RequestBody PurchasedProduct product) throws ResourceNotFound {
        purchasedproductService.updatePurchasedProductInDB(product, productId);
    }

}
