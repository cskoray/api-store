package com.solidcode.apistore.service;

import static java.time.LocalDateTime.now;

import com.solidcode.apistore.adaptor.ZilchClient;
import com.solidcode.apistore.adaptor.request.ZilchBrandRequest;
import com.solidcode.apistore.adaptor.response.ZilchBrandResponse;
import com.solidcode.apistore.dto.request.ProductRequest;
import com.solidcode.apistore.dto.response.ProductAmountResponse;
import com.solidcode.apistore.mapper.ProductMapper;
import com.solidcode.apistore.repository.ProductRepository;
import com.solidcode.apistore.repository.entity.Product;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RefreshScope
public class ProductService {

  private ProductRepository productRepository;
  private ProductMapper productMapper;
  private ZilchClient zilchClient;

  @Autowired
  public ProductService(ProductRepository productRepository, ProductMapper productMapper,
      ZilchClient zilchClient) {
    this.productRepository = productRepository;
    this.productMapper = productMapper;
    this.zilchClient = zilchClient;
  }

  public Product saveProduct(ProductRequest request) {

    log.info("ProductService: saveProduct {}", request.toString());
    Product product = productMapper.toProduct(request);
    product.setCreatedDate(Timestamp.valueOf(now()));
    product.setProductKey(UUID.randomUUID().toString());
    return productRepository.save(product);
  }

  public ZilchBrandResponse registerBrand(ZilchBrandRequest zilchBrandRequest) {

    return zilchClient.register(zilchBrandRequest);
  }

  public ProductAmountResponse getTotalAmount(List<String> productKeys) {

    BigDecimal totalAmount = BigDecimal.ZERO;
    Optional<List<Product>> products = productRepository.findByProductKeys(productKeys);
    if (products.isPresent()) {
      totalAmount = products.get().stream()
          .map(Product::getPrice)
          .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
    return ProductAmountResponse.builder()
        .amount(totalAmount)
        .build();
  }
}
