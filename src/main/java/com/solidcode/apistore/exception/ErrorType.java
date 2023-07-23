package com.solidcode.apistore.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public enum ErrorType {

  PRODUCT_NOT_FOUND("10001", "Product cannot be found.", BAD_REQUEST),
  DUPLICATE_PRODUCT("10002", "Product exists.", BAD_REQUEST),
  INVALID_FIELD("10003", "Invalid field.", BAD_REQUEST);

  private String code;
  private String message;
  private HttpStatus httpStatus;
}
