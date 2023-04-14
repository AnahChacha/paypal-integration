package com.pay.paypal.dbEntity.subscriptions.catalogProducts;


import com.pay.paypal.dbEntity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products_tb")
@Entity
public class CreateProducts extends BaseEntity {
    @Column(name = "home_url")
    private String homeUrl;
    @Column(name = "image_url")
    private String imageUrl;
    @Column(name = "product_name")
    private String name;
    @Column(name = "product_desc")
    private String description;
    @Column(name = "product_id")
    private String productId;
    @Column(name = "product_type")
    private String type;
    @Column(name = "product_category")
    private String category;
}
