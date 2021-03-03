package com.BookCatalogDesign.BookCatalogDesign.dao;

import com.BookCatalogDesign.BookCatalogDesign.model.Author;
import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class AuthorDao implements AuthorOperations{
    HashMap<UUID,Author> authorInfoDb = new HashMap<UUID, Author>();
    @Override
    public List<Author> getAllAuthors() {
        return new ArrayList<>(authorInfoDb.values());
    }

    @Override
    public boolean addAuthors(Author author) {
        authorInfoDb.put(author.getAuthorId(),author);
        return true;
    }

    @Override
    public boolean searchBookByAuthorName(String authorName) {
        return false;
    }

    @Override
    public List<Book> getMostSoldBooksByAuthorName(String authorName) {
        return null;
    }
    @Override
    public boolean isAuthorPresent(String authorName){
        boolean isPresent = false;
        for (UUID authorId : authorInfoDb.keySet()) {
            isPresent = authorInfoDb.get(authorId).getAuthorName().equals(authorName);
        }
        return isPresent;
    }

    @Override
    public Optional<UUID> getAuthorId(String authorName) {
        for(UUID authorId : authorInfoDb.keySet()){
            if(authorInfoDb.get(authorId).getAuthorName().equals(authorName)){
                return Optional.of(authorId);
            }
        }
        return Optional.empty();
    }

    public Optional<UUID> findauthorId(String authorName){
        for(UUID authorId : authorInfoDb.keySet()){
            if(authorInfoDb.get(authorId).getAuthorName().equals(authorName)){
                return Optional.of(authorId);
            }

        }
        return Optional.empty();
    }

}
