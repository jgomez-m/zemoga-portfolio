package com.zemoga.portfolio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {
        super("User could not be found with id: " + id);
    }
    public UserNotFoundException(String userName) {
        super("User could not be found with userName: " + userName);
    }

}
