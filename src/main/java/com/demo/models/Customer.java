package com.demo.models;

import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_email")
    private String email;
    @Column(name = "customer_contact")
    private Long contact;
    @Column(name = "purchased_date")
    private String date;
    @Column(name = "total_price")
    private Float totalPrice;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private Set<PurchasedProduct> list = new HashSet<>();

    public Customer() {
        totalPrice = (float) 0;
    }
    public Customer(String customerName, String email, Long contact, String date, Float totalPrice) {
        this.customerName = customerName;
        this.email = email;
        this.contact = contact;
        this.date = date;
        this.totalPrice = totalPrice;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getContact() {
        return contact;
    }

    public void setContact(Long contact) {
        this.contact = contact;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<PurchasedProduct> getList() {
        return list;
    }

    public void setList(Set<PurchasedProduct> list) {
        this.list = list;
    }

}
