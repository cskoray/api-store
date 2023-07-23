package com.solidcode.apistore.repository.entity;

import static jakarta.persistence.GenerationType.IDENTITY;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "products")
public class Product {

  @Id
  @GeneratedValue(strategy = IDENTITY)
  private long id;

  @Column(name = "product_key", nullable = false)
  private String productKey;

  @Column(name = "name", nullable = false)
  private String name;

  @Column(name = "brand", nullable = false)
  private String brand;

  @Column(name = "price", nullable = false)
  private BigDecimal price;

  @Column(name = "created_date", updatable = false, nullable = false)
  private Timestamp createdDate;
}
