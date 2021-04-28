package com.renanmartins.bookstoremanager.publishers.repository;

import com.renanmartins.bookstoremanager.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
}
