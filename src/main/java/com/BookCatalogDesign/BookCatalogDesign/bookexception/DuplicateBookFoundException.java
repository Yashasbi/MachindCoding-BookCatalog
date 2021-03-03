package com.BookCatalogDesign.BookCatalogDesign.bookexception;

public class DuplicateBookFoundException extends  Exception{
    public DuplicateBookFoundException(String message){
        super(message);
    }
}
