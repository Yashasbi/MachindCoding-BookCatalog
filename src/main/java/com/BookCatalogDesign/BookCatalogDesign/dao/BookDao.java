package com.BookCatalogDesign.BookCatalogDesign.dao;

import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import com.BookCatalogDesign.BookCatalogDesign.model.BookCategory;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class BookDao implements BookOperations{
    HashMap<UUID, Book> storeAllBookDetails = new HashMap<>();
    @Override
    public boolean addBookToCatalog(Book book) {
        storeAllBookDetails.put(book.getBookId(),book);
        return true;
    }

    @Override
    public List<BookCategory> getListofBookCategories() {
        return null;
    }

    @Override
    public Optional<Book> searchBookByBookId(UUID bookId) {
           if(storeAllBookDetails.containsKey(bookId)){
               return Optional.of(storeAllBookDetails.get(bookId));
           }
           return Optional.empty();

        //return null;
    }

    @Override
    public List<Book> getMostSoldBooks(UUID authorId) {
        return null;
    }
    @Override
    public List<Book> searchBook(String fieldToBeSearched){
        System.out.println("Dao");
        List<Book> list = new ArrayList<>();
        for (UUID key : storeAllBookDetails.keySet()) {
            Book book = storeAllBookDetails.get(key);
            if(book.getBookName().equals(fieldToBeSearched)) {
                list.add(book);
                return list;
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<Book> getBookByAuthorId(UUID authorId) {
        List<Book> list = new ArrayList<>();
        for (UUID key : storeAllBookDetails.keySet()) {
            Book book = storeAllBookDetails.get(key);
            if(book.getAuthorId().equals(authorId)) {
                list.add(book);
                return list;
            }
        }
        return Collections.emptyList();
    }

    public List<Book> searchBookByBookName(String bookName){
        return searchBook(bookName);
    }



}
