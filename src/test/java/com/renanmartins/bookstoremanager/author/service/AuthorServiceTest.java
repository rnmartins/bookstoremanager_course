package com.renanmartins.bookstoremanager.author.service;

import com.renanmartins.bookstoremanager.author.builder.AuthorDTOBuilder;
import com.renanmartins.bookstoremanager.author.dto.AuthorDTO;
import com.renanmartins.bookstoremanager.author.mapper.AuthorMapper;
import com.renanmartins.bookstoremanager.author.repository.AuthorRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AuthorServiceTest {

    private final AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    @Mock
    private AuthorRepository authorRepository;

    @InjectMocks
    private AuthorService authorService;

    private AuthorDTOBuilder authorDTOBuilder;

    @BeforeEach
    void setUp() {
        authorDTOBuilder.builder().build();
    }
}
