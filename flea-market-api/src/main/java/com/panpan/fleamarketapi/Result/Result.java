package com.panpan.fleamarketapi.Result;

import lombok.Data;

/**
 * 统一API响应结果封装
 */
@Data
public class Result {
    private int code;
    private String message;
    private Object data;

    public Result(ResultCode resultCode, String message) {
        this.code = resultCode.code;
        this.message = message;
    }

    public Result(ResultCode resultCode, String message, Object data) {
        this.code = resultCode.code;
        this.message = message;
        this.data = data;
    }
}
