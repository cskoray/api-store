package com.solidcode.apistore.repository;

import com.solidcode.apistore.repository.entity.Product;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  @Query(value = "SELECT * FROM "
      + "products "
      + "where product_key in :productKeys", nativeQuery = true)
  Optional<List<Product>> findByProductKeys(@Param("productKeys") List<String> productKeys);
}
