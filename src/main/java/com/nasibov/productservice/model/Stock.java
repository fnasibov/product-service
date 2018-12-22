package com.nasibov.productservice.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@AllArgsConstructor
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sku")
    private Product product;


    @NonNull
    @NotNull
    private int count;
}
