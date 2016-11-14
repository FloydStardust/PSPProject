package com.psp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 资源未找到时抛出
 * Created by jankin on 13/11/2016.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException() {
        this("Sorry, resource not found.");
    }
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
