package com.renanmartins.bookstoremanager.author.service;
import com.renanmartins.bookstoremanager.author.dto.AuthorDTO;
import com.renanmartins.bookstoremanager.author.entity.Author;
import com.renanmartins.bookstoremanager.author.exception.AuthorAlreadyExistsException;
import com.renanmartins.bookstoremanager.author.exception.AuthorNotFoundException;
import com.renanmartins.bookstoremanager.author.mapper.AuthorMapper;
import com.renanmartins.bookstoremanager.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public AuthorDTO create(AuthorDTO authorDTO) {
        verifyIfExists(authorDTO);

        Author authorToCreate = authorMapper.toModel(authorDTO);
        Author createdAuthor = authorRepository.save(authorToCreate);
        return authorMapper.toDTO(createdAuthor);
    }

    public AuthorDTO findById(Long id) {
        Author foundAuthor = authorRepository.findById(id)
                .orElseThrow(() -> new AuthorNotFoundException(id));
        return authorMapper.toDTO(foundAuthor);
    }

    public List<AuthorDTO> findAll() {
        return authorRepository.findAll()
                .stream()
                .map(authorMapper::toDTO)
                .collect(Collectors.toList());
    }

    private void verifyIfExists(AuthorDTO authorName) {
        authorRepository.findByName(authorName.getName())
                .ifPresent(author -> {throw new AuthorAlreadyExistsException(authorName);});
    }
}
