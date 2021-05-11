package com.renanmartins.bookstoremanager.author.exception;

import com.renanmartins.bookstoremanager.author.dto.AuthorDTO;

import javax.persistence.EntityExistsException;

public class AuthorAlreadyExistsException extends EntityExistsException {
    public AuthorAlreadyExistsException(AuthorDTO name) {
        super(String.format("User with name %s already exists!", name));
    }
}
