package com.renanmartins.bookstoremanager.books.service;

import com.renanmartins.bookstoremanager.author.service.AuthorService;
import com.renanmartins.bookstoremanager.books.builder.BookRequestDTOBuilder;
import com.renanmartins.bookstoremanager.books.builder.BookResponseDTOBuilder;
import com.renanmartins.bookstoremanager.books.dto.BookRequestDTO;
import com.renanmartins.bookstoremanager.books.mapper.BookMapper;
import com.renanmartins.bookstoremanager.books.repository.BookRepository;
import com.renanmartins.bookstoremanager.publishers.service.PublisherService;
import com.renanmartins.bookstoremanager.users.dto.AuthenticatedUser;
import com.renanmartins.bookstoremanager.users.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    private final BookMapper bookMapper = BookMapper.INSTANCE;

    @Mock
    private BookRepository bookRepository;

    @Mock
    private UserService userService;

    @Mock
    private AuthorService authorService;

    @Mock
    private PublisherService publisherService;

    @InjectMocks
    private BookService bookService;

    private BookRequestDTOBuilder bookRequestDTOBuilder;

    private BookResponseDTOBuilder bookResponseDTOBuilder;

    private AuthenticatedUser authenticatedUser;

    @BeforeEach
    void setUp() {
        bookRequestDTOBuilder = BookRequestDTOBuilder.builder().build();
        bookResponseDTOBuilder = BookResponseDTOBuilder.builder().build();
        authenticatedUser = new AuthenticatedUser("renan", "123456", "ADMIN");
    }
}
