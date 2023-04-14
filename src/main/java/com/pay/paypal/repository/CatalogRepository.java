package com.pay.paypal.repository;

import com.pay.paypal.dbEntity.subscriptions.catalogProducts.CreateProducts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CatalogRepository extends JpaRepository<CreateProducts,String> {

}
