package com.nearsoft.controller;

import com.nearsoft.model.Product;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * This is the product facade to manage products.
 */
@RequestMapping("/product/")
public interface ProductApi {

  /**
   * This method retrieves all the products in the data base.
   *
   * @return {@link Product} A list of all the products.
   */
  @GetMapping
  ResponseEntity<List<Product>> retrieveProducts();

}
