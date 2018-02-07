package com.cat.exception;

/**
 * Created by 周杰伦 on 2018/1/24.
 */
public class HubException extends Exception{
    String message;
    public HubException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
