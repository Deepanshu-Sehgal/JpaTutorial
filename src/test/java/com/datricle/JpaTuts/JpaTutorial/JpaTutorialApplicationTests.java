package com.datricle.JpaTuts.JpaTutorial;

import com.datricle.JpaTuts.JpaTutorial.entities.ProductEntity;
import com.datricle.JpaTuts.JpaTutorial.reposotories.ProductRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;
import java.util.List;

@SpringBootTest
class JpaTutorialApplicationTests {

    @Autowired
    ProductRepository productRepository;

    @Test
    void contextLoads() {
    }

    @Test
    void testRepository() {
        ProductEntity productEntity = ProductEntity.builder()
                .sku("nestle234")
                .title("Nestle choco")
                .price(BigDecimal.valueOf(123.45))
                .quantity(12)
                .build();

        ProductEntity productSaved = productRepository.save(productEntity);
        System.out.println(productSaved);
    }

    @Test
    void getRepository(){

        List<ProductEntity> entities = productRepository.findAll();
        for (int i = 0; i < entities.size(); i++) {
            System.out.println(entities.get(i));
        }
    }

}