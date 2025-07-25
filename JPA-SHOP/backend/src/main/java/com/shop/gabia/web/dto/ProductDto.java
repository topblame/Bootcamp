package com.shop.gabia.web.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import com.shop.gabia.domain.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//DAO
public class ProductDto {
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateRequest {
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stockQuantity;
        private String category;
        private String imageUrl;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class UpdateRequest {
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stockQuantity;
        private String category;
        private String imageUrl;
        private Product.Status status;
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ProductResponse {
        //데이터 베이스와 연결
        private Long id;
        private String name;
        private String description;
        private BigDecimal price;
        private Integer stockQuantity;
        private String category;
        private String imageUrl;
        private Product.Status status;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
        
        public static ProductResponse from(Product product) {
            return ProductResponse.builder()
                    .id(product.getId())
                    .name(product.getName())
                    .description(product.getDescription())
                    .price(product.getPrice())
                    .stockQuantity(product.getStockQuantity())
                    .category(product.getCategory())
                    .imageUrl(product.getImageUrl())
                    .status(product.getStatus())
                    .createdAt(product.getCreatedAt())
                    .updatedAt(product.getUpdatedAt())
                    .build();
        }
    }
    
    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SearchRequest {
        private String keyword;
        private String category;
        private BigDecimal minPrice;
        private BigDecimal maxPrice;
        private Product.Status status;
        private Integer page = 0;
        private Integer size = 10;
    }
}
