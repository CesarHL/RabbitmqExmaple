package com.nearsoft.service;

import com.nearsoft.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

/**
 *
 */
public class ProductServiceTest {

  /**
   *
   */
  private ProductService productService;

  /**
   *
   */
  @Mock
  private ProductRepository productRepository = Mockito.mock(ProductRepository.class);

  /**
   *
   */
  @BeforeEach
  void setUp() {
    productService = new ProductService(productRepository);
  }

  /**
   * Given:
   * <p>
   * When:
   * <p>
   * Then:
   */
  @Test
  void retrieveProducts() {

  }

}
