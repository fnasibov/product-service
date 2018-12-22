package com.nasibov.productservice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Map;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @NotNull
    @Column(unique = true)
    private String sku;

    @NotNull
    @NonNull
    private String name;

    @NotNull
    @NonNull
    private double price;

    @NotNull
    @NonNull
    @OneToOne(
            mappedBy = "product",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            optional = false
    )
    private Stock stock;

    @ElementCollection
    private Map<String, String> attributes;
}

