package com.panpan.fleamarketapi.exception;

/**
 * 系统业务中可能发生的所有错误类型的枚举，包含错误码、错误原因、问题恢复建议。
 */
public enum SystemError {
    UserNotExistError(10002, "未找到用户", "请尝试重新注册账户");



    /**
     * 错误码，内部沟通使用
     */
    private long errCode;
    /**
     * 错误信息，返回给前端向用户展示，错误的简单解释
     */
    private String errMsg;
    /**
     * 恢复方法，告诉用户可能的从错误中恢复的方式，或者是求助方法
     */
    private String recover;

    SystemError(long errCode, String errMsg, String recover) {
        this.errCode = errCode;
        this.errMsg = errMsg;
        this.recover = recover;
    }
    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public String getRecover() {
        return recover;
    }

    public void setRecover(String recover) {
        this.recover = recover;
    }
}
