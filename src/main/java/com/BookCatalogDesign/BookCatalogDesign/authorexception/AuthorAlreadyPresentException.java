package com.BookCatalogDesign.BookCatalogDesign.authorexception;

public class AuthorAlreadyPresentException extends Exception{
    public AuthorAlreadyPresentException(String s){
        super(s);
    }
}
