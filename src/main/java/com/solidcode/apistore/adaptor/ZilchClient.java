package com.solidcode.apistore.adaptor;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import com.solidcode.apistore.adaptor.request.ZilchBrandRequest;
import com.solidcode.apistore.adaptor.response.ZilchBrandResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient("ZILCH-PAY")
public interface ZilchClient {

  @PostMapping(value = "/v1/api/zilch/brands/register", produces = APPLICATION_JSON_VALUE, consumes = APPLICATION_JSON_VALUE)
  ZilchBrandResponse register(ZilchBrandRequest request);
}
