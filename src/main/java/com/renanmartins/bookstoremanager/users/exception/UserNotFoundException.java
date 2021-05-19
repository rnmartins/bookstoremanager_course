package com.renanmartins.bookstoremanager.users.exception;

import javax.persistence.EntityNotFoundException;

public class UserNotFoundException extends EntityNotFoundException {

    public UserNotFoundException(Long id) {
        super(String.format("user with id %s not exists!", id));
    }
}
