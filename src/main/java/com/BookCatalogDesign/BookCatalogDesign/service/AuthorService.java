package com.BookCatalogDesign.BookCatalogDesign.service;

import com.BookCatalogDesign.BookCatalogDesign.authorexception.AuthorAlreadyPresentException;
import com.BookCatalogDesign.BookCatalogDesign.bookexception.NoSucBookExistsInDb;
import com.BookCatalogDesign.BookCatalogDesign.dao.AuthorDao;
import com.BookCatalogDesign.BookCatalogDesign.dao.BookDao;
import com.BookCatalogDesign.BookCatalogDesign.model.Author;
import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class AuthorService {
    @Autowired
    AuthorDao authorDao;
    @Autowired
    BookDao bookDao;
    public String addAuthorToDb(Author author){
        try{
            if(authorDao.isAuthorPresent(author.getAuthorName())){
                throw new AuthorAlreadyPresentException("Author details already present in db");
            }
            else{
                authorDao.addAuthors(author);
            }
        }
        catch(AuthorAlreadyPresentException authorAlreadyPresentException){
            return authorAlreadyPresentException.getMessage();
        }
        return  "Author successfully added to db";
    }
    public List<Author> getAllAuthorDetails(){
        return authorDao.getAllAuthors();
    }
    public List<Book> searchBookByAuthorName(String authorName) throws NoSucBookExistsInDb {
        List<Book> bookList = new ArrayList<>();
        if(authorDao.isAuthorPresent(authorName)){
            bookList = bookDao.getBookByAuthorId(authorDao.getAuthorId(authorName).get());
        }
      if(bookList.size() == 0){
          throw new NoSucBookExistsInDb("No such book exists in db..Please enter a valid authorName");
      }
       return bookList;
    }
}
