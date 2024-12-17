package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "productline_id", nullable = false)
    @ToString.Exclude
    private ProductLine productLine;

    @Column(name = "productline_id", insertable = false, updatable = false)
    private int productlineId;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "product_name")
    private String productName;



    @Column(name = "product_scale")
    private String productScale;

    @Column(name = "product_vendor")
    private String productVendor;

    @Column(name = "product_description", columnDefinition = "TEXT")
    private String productDescription;

    @Column(name = "quantity_in_stock", columnDefinition = "SMALLINT")
    private int quantityInStock;

    @Column(name = "buy_price", columnDefinition = "DECIMAL")
    private double buyPrice;

    @Column(name = "msrp", columnDefinition = "DECIMAL")
    private double msrp;



}
