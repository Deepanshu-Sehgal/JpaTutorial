package com.datricle.JpaTuts.JpaTutorial.reposotories;


import com.datricle.JpaTuts.JpaTutorial.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    List<ProductEntity> findByTitle(String title);

    List<ProductEntity> findByCreatedAtAfter(LocalDateTime after);


    List<ProductEntity> findByQuantityAndPrice(int quantity, BigDecimal bigDecimal);


    List<ProductEntity> findByTitleLike(String title);

    List<ProductEntity> findByTitleContaining(String title);
}