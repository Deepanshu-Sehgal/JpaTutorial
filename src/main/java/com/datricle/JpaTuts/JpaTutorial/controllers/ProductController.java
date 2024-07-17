package com.datricle.JpaTuts.JpaTutorial.controllers;

import com.datricle.JpaTuts.JpaTutorial.entities.ProductEntity;
import com.datricle.JpaTuts.JpaTutorial.reposotories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/products")
public class ProductController {

    private final int PAGE_SIZE = 5;
    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public List<ProductEntity> getAllProducts(
            @RequestParam(defaultValue = "") String title,
            @RequestParam(defaultValue = "id") String sortBy,
            @RequestParam(defaultValue = "1") Integer pageNumber) {

        return productRepository.findByTitleContainingIgnoreCase(
                title,
                PageRequest.of(
                        pageNumber,
                        PAGE_SIZE,
                        Sort.by(sortBy)
                )

        );


//        Sort sort = Sort.by(Sort.Direction.DESC,sortBy,"price");
//        Sort sort = Sort.by(
//                Sort.Order.desc(sortBy),
//                Sort.Order.desc("title")
//        );
//        return productRepository.findBy(sort);

//
//        Pageable pageable = PageRequest.of(
//                pageNumber,
//                PAGE_SIZE);
//        return productRepository.findAll(pageable).getContent();
    }
}