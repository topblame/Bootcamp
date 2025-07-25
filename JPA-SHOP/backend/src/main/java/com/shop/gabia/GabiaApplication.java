package com.shop.gabia;

import java.math.BigDecimal;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.shop.gabia.service.ProductService;
import com.shop.gabia.web.dto.ProductDto;

@SpringBootApplication
public class GabiaApplication {
	public static void main(String[] args) {
		SpringApplication.run(GabiaApplication.class, args);
	}
	 @Bean
   public CommandLineRunner init(ProductService productService) {
      return args -> {
         // 더미 데이터 생성
         IntStream.rangeClosed(1, 10).forEach(i -> {
            ProductDto.CreateRequest request = ProductDto.CreateRequest.builder()
                  .name("테스트 상품 " + i)
                  .price(new BigDecimal(10000 + i * 1000))
                  .category("테스트 카테고리")
                  .description("이것은 테스트 상품입니다. " + i)
                  .imageUrl("https://via.placeholder.com/150")
                  .stockQuantity(100)
                  .build();
            productService.createProduct(request);
         });
      };
   }
}
