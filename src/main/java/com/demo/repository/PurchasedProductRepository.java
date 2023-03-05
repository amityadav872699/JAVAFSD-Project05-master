package com.demo.repository;

import com.demo.models.PurchasedProduct;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PurchasedProductRepository extends JpaRepository<PurchasedProduct, Long> {

    public List<PurchasedProduct> findByCategory(String category);

    // Complex Queries.
    @Query("from PurchasedProduct where customer_id=:id")
    public List<PurchasedProduct> findByCustomerId(@Param("id") Long id);

}
