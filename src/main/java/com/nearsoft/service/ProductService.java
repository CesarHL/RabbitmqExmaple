package com.nearsoft.service;

import com.nearsoft.model.Product;
import com.nearsoft.repository.ProductRepository;
import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 *
 */
@Slf4j
@Service
public class ProductService {

  /**
   *
   */
  private final ProductRepository productRepository;

  /**
   *
   */
  public ProductService(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  /**
   * @return
   */
  public List<Product> retrieveProducts() {
    return Arrays.asList(Product.builder()
        .id(1)
        .name("Potatoes")
        .price("12.50").build());
  }

}
