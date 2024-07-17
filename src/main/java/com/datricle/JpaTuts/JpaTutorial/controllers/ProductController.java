package com.datricle.JpaTuts.JpaTutorial.controllers;

import com.datricle.JpaTuts.JpaTutorial.entities.ProductEntity;
import com.datricle.JpaTuts.JpaTutorial.reposotories.ProductRepository;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {


    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(@RequestParam(defaultValue = "id") String sortBy) {
//        Sort sort = Sort.by(Sort.Direction.DESC,sortBy,"price");
        Sort sort = Sort.by(Sort.Order.desc(sortBy));
        return productRepository.findBy(sort);
    }
}