package org.engripaye.librarymanagementsystem.repository;

import org.engripaye.librarymanagementsystem.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<AppUser, Long> {
}
