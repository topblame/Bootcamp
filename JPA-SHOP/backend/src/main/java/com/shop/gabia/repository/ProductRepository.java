package com.shop.gabia.repository;

import com.shop.gabia.domain.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    //상태별 상품 조회
    Page<Product> findByStatus(Product.Status status, Pageable pageable);
    // 카테고리별
    Page<Product> findByCategory(String category, Pageable pageable);
    // 가격범위로 
    @Query("SELECT p FROM Product p WHERE p.price BETWEEN :minPrice AND :maxPrice")
    Page<Product> findByPriceRange(@Param("minPrice") BigDecimal minPrice, 
                                   @Param("maxPrice") BigDecimal maxPrice, 
                                   Pageable pageable);
    // 키워드 상품 조회
    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(CONCAT('%', :keyword, '%')) OR LOWER(p.description) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<Product> findByKeyword(@Param("keyword") String keyword, Pageable pageable);
    //최신 상품 10개 조회
    List<Product> findTop10ByOrderByCreatedAtDesc();
    // 재고가 있고 활성화된 상품만 조회
    @Query("SELECT p FROM Product p WHERE p.stockQuantity > 0 AND p.status = 'ACTIVE'")
    Page<Product> findAvailableProducts(Pageable pageable);
} 