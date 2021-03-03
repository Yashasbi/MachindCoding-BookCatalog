package com.BookCatalogDesign.BookCatalogDesign.dao;

import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import com.BookCatalogDesign.BookCatalogDesign.model.BookCategory;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BookOperations {
    public boolean addBookToCatalog(Book book);
    public List<BookCategory> getListofBookCategories();
    public Optional<Book> searchBookByBookId(UUID bookId);
    public List<Book> getMostSoldBooks(UUID authorId);
    public List<Book> searchBook(String bookName);
    public List<Book> getBookByAuthorId(UUID authorId);
    public Book getMostSoldBookByLimit();
}
