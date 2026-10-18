package com.platform.library.repository;

import com.platform.library.entity.BookEntity;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<@NotNull BookEntity, @NotNull Long> {

    boolean existsByIsbn(String isbn);
}
