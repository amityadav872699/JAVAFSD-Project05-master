package com.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "purchased_product")
public class PurchasedProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    private Long productId;
    @Column(name = "product_category")
    private String category;
    @Column(name = "product_company")
    private String company;
    @Column(name = "product_size")
    private int size;
    @Column(name = "product_origin")
    private String origin;
    @Column(name = "product_price")
    private Float price;
    @Column(name = "product_tag")
    private int tag;

    public PurchasedProduct()    {
    }
    public PurchasedProduct(String category, String company, int size, String origin, Float price, int tag) {
        this.category = category;
        this.company = company;
        this.size = size;
        this.origin = origin;
        this.price = price;
        this.tag = tag;
    }

    public Long getProductId() {
        return productId;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getCategory() {
        return category;
    }
    public void setCategory(String category) {
        this.category = category;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public int getSize() {
        return size;
    }
    public void setSize(int size) {
        this.size = size;
    }

    public String getOrigin() {
        return origin;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Float getPrice() {
        return price;
    }
    public void setPrice(Float price) {
        this.price = price;
    }

    public int getTag() {
        return tag;
    }
    public void setTag(int tag) {
        this.tag = tag;
    }

}
