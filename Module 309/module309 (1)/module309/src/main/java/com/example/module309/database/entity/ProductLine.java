package org.example.database.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "productlines")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductLine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "product_line")
    private String product_line;

    @Column(name = "description")
    private String description;
}
