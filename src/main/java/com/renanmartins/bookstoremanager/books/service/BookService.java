package com.renanmartins.bookstoremanager.books.service;

import com.renanmartins.bookstoremanager.author.service.AuthorService;
import com.renanmartins.bookstoremanager.books.mapper.BookMapper;
import com.renanmartins.bookstoremanager.books.repository.BookRepository;
import com.renanmartins.bookstoremanager.publishers.service.PublisherService;
import com.renanmartins.bookstoremanager.users.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class BookService {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    private BookRepository bookRepository;

    private UserService userService;

    private AuthorService authorService;

    private PublisherService publisherService;

}
