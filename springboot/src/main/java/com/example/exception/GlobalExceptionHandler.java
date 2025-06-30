package com.example.exception;

import com.example.common.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常捕获器
 */
@ControllerAdvice("com.example.controller")
public class GlobalExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseBody // 将result对象转换成 json的格式
    public R error(Exception e) {
        log.error("系统异常", e);
        return R.error("系统异常");
    }

    @ExceptionHandler(CustomerException.class)
    @ResponseBody // 将result对象转换成 json的格式
    public R customerError(CustomerException e) {
        log.error("出现了未知的错误", e);
        return R.error(Integer.valueOf(e.getCode()), e.getMsg());
    }

}