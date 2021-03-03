package com.BookCatalogDesign.BookCatalogDesign.service;

import com.BookCatalogDesign.BookCatalogDesign.dao.BookDao;
import com.BookCatalogDesign.BookCatalogDesign.bookexception.DuplicateBookFoundException;
import com.BookCatalogDesign.BookCatalogDesign.bookexception.NoSucBookExistsInDb;
import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


@Component
public class BookService {
    @Autowired
    BookDao bookDao;
    public String addBookToDb(Book b){
        try {
               Optional<Book> fetchedBook = bookDao.searchBookByBookId(b.getBookId());
                if(fetchedBook.isPresent()){
                    throw new DuplicateBookFoundException("This book is already inserted in the database.Try inserting another book.");
                }
                else{
                    bookDao.addBookToCatalog(b);
                }

            }
            catch (DuplicateBookFoundException e) {
                return e.getMessage();
            }
        return "Book successfully added to db";
    }
    public List<Book> searchBookInDb(String bookName) throws NoSucBookExistsInDb {
        System.out.println("Service");
        List<Book> book = bookDao.searchBookByBookName(bookName);
        if(book.size() != 0) {
            return book;
        } else {
            throw new NoSucBookExistsInDb("There is no such book with bookName " +bookName + ".Please enter a valid bookName");
        }
    }
}
