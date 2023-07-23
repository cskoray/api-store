package com.solidcode.apistore.mapper;


import com.solidcode.apistore.dto.request.ProductRequest;
import com.solidcode.apistore.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

  Product toProduct(ProductRequest productRequest);

}
