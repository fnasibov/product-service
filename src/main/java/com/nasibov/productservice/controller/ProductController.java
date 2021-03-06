package com.nasibov.productservice.controller;

import com.nasibov.productservice.model.Product;
import com.nasibov.productservice.model.Stock;
import com.nasibov.productservice.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/getAll")
    public List<Product> getProductList() {
        return productRepository.findAll();
    }

    @PostMapping("/save")
    public void saveProduct(@RequestBody Product product) {
        Stock stock = new Stock();
        stock.setCount(product.getStock().getCount());
        stock.setProduct(product);
        product.setStock(stock);
        productRepository.save(product);
    }

}
