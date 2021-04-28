package com.renanmartins.bookstoremanager.author.repository;

import com.renanmartins.bookstoremanager.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
