package com.BookCatalogDesign.BookCatalogDesign.dao;

import com.BookCatalogDesign.BookCatalogDesign.model.Author;
import com.BookCatalogDesign.BookCatalogDesign.model.Book;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AuthorOperations {
    public List<Author> getAllAuthors();
    public boolean addAuthors(Author author);
    public boolean searchBookByAuthorName(String authorName);
    public List<Book> getMostSoldBooksByAuthorName(String authorName);
    public boolean isAuthorPresent(String authorName);
    public Optional<UUID> getAuthorId(String authorName);
}
