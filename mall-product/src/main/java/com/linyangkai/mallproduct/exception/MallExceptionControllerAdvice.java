package com.linyangkai.mallproduct.exception;


import com.linyangkai.common.utils.R;
import java.util.HashMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(basePackages = "com.linyangkai.mallproduct.controller")
public class MallExceptionControllerAdvice {

  @ExceptionHandler(value = MethodArgumentNotValidException.class)
  public R handleVaildException(MethodArgumentNotValidException e){
    BindingResult bindingResult = e.getBindingResult();
    HashMap<String, String> errorMap = new HashMap<>();
    bindingResult.getFieldErrors().forEach(error->{
      errorMap.put(error.getField(),error.getDefaultMessage());
    });
    return R.error(400,"数据校验").put("data",errorMap);
  }
}
