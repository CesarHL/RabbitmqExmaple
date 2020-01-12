package com.nearsoft.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.nearsoft.model.Product;
import com.nearsoft.service.ProductService;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

public class ProductControllerTest {

  /**
   *
   */
  private ProductController productController;

  /**
   *
   */
  @Mock
  private ProductService productService = Mockito.mock(ProductService.class);

  /**
   *
   */
  @BeforeEach
  void setUp() {
    productController = new ProductController(productService);
  }

  /**
   * Given: a request from controller endpoint.
   *
   * When: product services is available.
   *
   * Then: retrieves 200 ok response entity and a valid list of products.
   */
  @Test
  void retrieveProducts() {
    List<Product> expectedProducts = Arrays.asList(Product.builder()
        .id(1)
        .name("Potatoes")
        .price("12.50").build());

    Mockito.doReturn(expectedProducts)
        .when(productService)
        .retrieveProducts();

    ResponseEntity<List<Product>> responseEntity = productController.retrieveProducts();
    assertTrue(responseEntity.getStatusCode().is2xxSuccessful());

    List<Product> products = responseEntity.getBody();
    assertEquals(expectedProducts, products);
  }

}
