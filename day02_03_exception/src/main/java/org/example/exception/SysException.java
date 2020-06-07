package org.example.exception;

/**
 * 自定義異常類
 */
public class SysException extends Exception {

    // 儲存提示訊息的
    private String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SysException(String message) {
        this.message = message;
    }
}