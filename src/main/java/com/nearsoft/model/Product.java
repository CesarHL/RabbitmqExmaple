package com.nearsoft.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This is the class business model for product entity.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Product implements Serializable {

  /**
   * This is the product identifier.
   */
  private Integer id;

  /**
   * This is the name of a specific product.
   */
  private String name;

  /**
   * This is the catalog value of a product.
   */
  private String price;

}
