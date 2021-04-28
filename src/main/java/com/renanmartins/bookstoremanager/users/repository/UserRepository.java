package com.renanmartins.bookstoremanager.users.repository;

import com.renanmartins.bookstoremanager.users.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
