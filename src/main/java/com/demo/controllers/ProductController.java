package com.demo.controllers;

import com.demo.exceptions.ResourceNotFound;
import com.demo.models.Product;
import com.demo.services.IProductService;

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
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("/insertproduct")
    public Product insertProduct(@RequestBody Product newProduct)	{
        return productService.insertProductInDB(newProduct);
    }

    @GetMapping("/getallproducts")
    public List<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @GetMapping("/getproduct/{productid}")
    public Product getProduct(@PathVariable("productid") Long productId) throws ResourceNotFound {
        return productService.getProductInDB(productId);
    }

    @DeleteMapping("/deleteproduct/{productid}")
    public void deleteProduct(@PathVariable("productid") Long productId) {
        productService.deleteProductInDB(productId);
    }

    @PutMapping("/updateproductbyid/{productid}")
    public void updateProduct(@PathVariable("productid") Long productId, @RequestBody Product product) throws ResourceNotFound {
        productService.updateProductInDB(product, productId);
    }

}
