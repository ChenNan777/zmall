package com.cn.zmall.product.exception;

import com.cn.zmall.common.exception.ErrorCodeEnum;
import com.cn.zmall.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice(basePackages = "com.cn.zmall.product.controller")
public class GlobalExceptionHandler {

    @ExceptionHandler(Throwable.class)
    public R handleException(Throwable e) {
        log.info("\n数据校验异常:{}\n异常类型:{}", e.getMessage(), e.getClass());
        return R.error();
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public R handlerConvertException(HttpMessageNotReadableException e){
        log.info("\n数据校验异常:{}\n异常类型:{}", e.getMessage(), e.getClass());
        return R.error(ErrorCodeEnum.CONVERT_EXCEPTION);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.info("\n数据校验异常:{}\n异常类型:{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();
        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError) -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        return R.error(ErrorCodeEnum.VALID_EXCEPTION).put("errors", errorMap);
    }

}
