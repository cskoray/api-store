package com.solidcode.apistore.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import com.solidcode.apistore.adaptor.request.ZilchBrandRequest;
import com.solidcode.apistore.adaptor.response.ZilchBrandResponse;
import com.solidcode.apistore.dto.request.ProductRequest;
import com.solidcode.apistore.dto.response.ProductAmountResponse;
import com.solidcode.apistore.repository.entity.Product;
import com.solidcode.apistore.service.ProductService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/v1/api/store/products")
@Validated
public class ProductController {

  private ProductService productService;

  @Autowired
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  @PostMapping
  @ResponseStatus(CREATED)
  public Product saveProduct(@Valid @RequestBody ProductRequest request) {

    log.info("ProductController: saveProduct {}", request.toString());
    return productService.saveProduct(request);
  }

  @PostMapping("/list")
  @ResponseStatus(OK)
  public ProductAmountResponse getTotalAmount(@Valid @RequestBody List<String> productKeys) {

    log.info("ProductController: getTotalAmount {}", productKeys.toString());
    return productService.getTotalAmount(productKeys);
  }

  @PostMapping("/zilch/register")
  @ResponseStatus(CREATED)
  public ZilchBrandResponse registerBrand(
      @Valid @RequestBody ZilchBrandRequest zilchBrandRequest) {

    log.info("ProductController: registerBrand {}", zilchBrandRequest.toString());
    return productService.registerBrand(zilchBrandRequest);
  }
}
