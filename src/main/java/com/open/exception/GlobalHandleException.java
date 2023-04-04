package com.open.exception;


import com.open.util.JsonResult;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleException {
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result = new JsonResult<>(e);

        if (e instanceof UseremailDuplicateException) {
            result.setState(4000);
        } else if (e instanceof InsertException) {
            result.setState(5000);
        }

        return result;
    }

}
