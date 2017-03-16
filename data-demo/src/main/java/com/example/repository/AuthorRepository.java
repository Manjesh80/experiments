package com.example.repository;

import com.example.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: mg153v (Manjesh Gowda). Creation Date: 3/16/2017.
 */
@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
