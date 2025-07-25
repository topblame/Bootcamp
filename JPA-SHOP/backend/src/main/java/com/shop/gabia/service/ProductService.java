package com.shop.gabia.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shop.gabia.domain.Product;
import com.shop.gabia.repository.ProductRepository;
import com.shop.gabia.web.dto.ProductDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {
private final ProductRepository productRepository;
    //  데이터베이스아 직접 통신하는 JPA 저장소
    @Transactional
    public ProductDto.ProductResponse createProduct(ProductDto.CreateRequest request) {
        Product product = Product.builder()
                .name(request.getName()) // web -> Data
                .description(request.getDescription())
                .price(request.getPrice())
                .stockQuantity(request.getStockQuantity())
                .category(request.getCategory())
                .imageUrl(request.getImageUrl())
                .status(Product.Status.ACTIVE)
                .build();

        Product savedProduct = productRepository.save(product);
        return ProductDto.ProductResponse.from(savedProduct);
    }
    //상품 단품조회
    public ProductDto.ProductResponse getProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));
        
        return ProductDto.ProductResponse.from(product);
    }
    //전체 상품 페이지 조회
    public Page<ProductDto.ProductResponse> getAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable)
                .map(ProductDto.ProductResponse::from);
    }
    //상품키워드
    public Page<ProductDto.ProductResponse> searchProducts(ProductDto.SearchRequest request) {
        Pageable pageable = PageRequest.of(request.getPage(), request.getSize());
        
        if (request.getKeyword() != null && !request.getKeyword().trim().isEmpty()) {
            return productRepository.findByKeyword(request.getKeyword(), pageable)
                    .map(ProductDto.ProductResponse::from);
        }
        
        if (request.getCategory() != null && !request.getCategory().trim().isEmpty()) {
            return productRepository.findByCategory(request.getCategory(), pageable)
                    .map(ProductDto.ProductResponse::from);
        }
        
        if (request.getMinPrice() != null && request.getMaxPrice() != null) {
            return productRepository.findByPriceRange(request.getMinPrice(), request.getMaxPrice(), pageable)
                    .map(ProductDto.ProductResponse::from);
        }
        
        if (request.getStatus() != null) {
            return productRepository.findByStatus(request.getStatus(), pageable)
                    .map(ProductDto.ProductResponse::from);
        }
        
        return productRepository.findAvailableProducts(pageable)
                .map(ProductDto.ProductResponse::from);
    }
    //전체상품 10개 조회
    public List<ProductDto.ProductResponse> getLatestProducts() {
        return productRepository.findTop10ByOrderByCreatedAtDesc()
                .stream()
                .map(ProductDto.ProductResponse::from)
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto.ProductResponse updateProduct(Long productId, ProductDto.UpdateRequest request) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));

        if (request.getName() != null) {
            product.setName(request.getName());
        }
        
        if (request.getDescription() != null) {
            product.setDescription(request.getDescription());
        }
        
        if (request.getPrice() != null) {
            product.setPrice(request.getPrice());
        }
        
        if (request.getStockQuantity() != null) {
            product.setStockQuantity(request.getStockQuantity());
        }
        
        if (request.getCategory() != null) {
            product.setCategory(request.getCategory());
        }
        
        if (request.getImageUrl() != null) {
            product.setImageUrl(request.getImageUrl());
        }
        
        if (request.getStatus() != null) {
            product.setStatus(request.getStatus());
        }

        return ProductDto.ProductResponse.from(product);
    }
    //상품삭제
    @Transactional
    public void deleteProduct(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new IllegalArgumentException("상품을 찾을 수 없습니다."));
        
        product.setStatus(Product.Status.INACTIVE);
    }
}
