package com.open.exception;


/**
 * 用户邮件冲突的异常
 */

public class UseremailDuplicateException extends RuntimeException{
    private static final long serialVersionUID = -1224474172375139228L;

    public UseremailDuplicateException() {
        super();
    }

    public UseremailDuplicateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UseremailDuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public UseremailDuplicateException(String message) {
        super(message);
    }

    public UseremailDuplicateException(Throwable cause) {
        super(cause);
    }

}
