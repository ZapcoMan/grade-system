package com.example.exception;

import com.example.common.ResultCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常
 * 运行时异常
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerException extends RuntimeException {
    private String code;
    private String msg;

    public CustomerException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public CustomerException(String msg) {
        this.code = String.valueOf(ResultCodeEnum.UNKNOWN_ERROR.getCode());
        this.msg = msg;
    }



}