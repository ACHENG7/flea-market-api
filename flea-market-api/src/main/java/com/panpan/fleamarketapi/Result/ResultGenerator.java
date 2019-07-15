package com.panpan.fleamarketapi.Result;

public class ResultGenerator {
    private static final String DEFAULT_SUCCESS_MESSAGE = "SUCCESS";

    public static Result getSuccessResult() {
        return new Result(ResultCode.SUCCESS, DEFAULT_SUCCESS_MESSAGE);
    }

    public static Result getSuccessResult(Object data) {
        return new Result(ResultCode.SUCCESS, DEFAULT_SUCCESS_MESSAGE, data);
    }

    public static Result getFailResult(String message) {
        return new Result(ResultCode.FAIL, message);

    }
}
