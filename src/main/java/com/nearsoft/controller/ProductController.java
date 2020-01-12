package com.nearsoft.controller;

import com.nearsoft.model.Product;
import com.nearsoft.service.ProductService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * This is the product controller.
 */
@Slf4j
@RestController
public class ProductController implements ProductApi {

  /**
   * This is the injection of the product service.
   */
  private final ProductService productService;

  /**
   * This is the all arguments constructor for inject beans in the controller.
   *
   * @param productService this is the product service.
   */
  public ProductController(ProductService productService) {
    this.productService = productService;
  }

  /**
   * This method retrieves all the products from database.
   *
   * @return A list of all the products.
   */
  @Override
  public ResponseEntity<List<Product>> retrieveProducts() {
    return ResponseEntity.ok(productService.retrieveProducts());
  }

}
