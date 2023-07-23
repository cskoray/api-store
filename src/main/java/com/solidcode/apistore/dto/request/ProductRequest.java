package com.solidcode.apistore.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class ProductRequest {

  @NotNull
  @Size(min = 3, max = 35)
  private String name;

  @NotNull
  @Size(min = 3, max = 35)
  private String brand;

  private BigDecimal price;
}
