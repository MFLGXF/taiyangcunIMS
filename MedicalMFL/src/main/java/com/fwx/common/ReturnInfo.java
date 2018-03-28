package com.fwx.common;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ReturnInfo<T> {

    private int result;

    private String msg;

    private String msgCode;

    private List<ObjectError> validateError;

    private T data;

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getMsgCode() {
        return msgCode;
    }

    public void setMsgCode(String msgCode) {
        this.msgCode = msgCode;
    }

    public List<ObjectError> getValidateError() {
        return validateError;
    }

    public void setValidateError(List<ObjectError> validateError) {
        this.validateError = validateError;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
