package com.renanmartins.bookstoremanager.books.entity;

import com.renanmartins.bookstoremanager.author.entity.Author;
import com.renanmartins.bookstoremanager.entity.Auditable;
import com.renanmartins.bookstoremanager.publishers.entity.Publisher;
import com.renanmartins.bookstoremanager.users.entity.User;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToOne;
import javax.persistence.CascadeType;
import javax.persistence.Id;

@Data
@Entity
public class Book extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false)
    private String isbn;

    @Column(columnDefinition = "integer default 0")
    private int pages;

    @Column(columnDefinition = "integer default 0")
    private int chapters;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Author author;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private Publisher publisher;

    @ManyToOne(cascade = {CascadeType.MERGE})
    private User user;
}
