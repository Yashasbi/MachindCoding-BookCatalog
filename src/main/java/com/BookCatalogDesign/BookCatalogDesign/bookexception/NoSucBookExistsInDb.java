package com.BookCatalogDesign.BookCatalogDesign.bookexception;

public class NoSucBookExistsInDb extends Exception{
    public NoSucBookExistsInDb(String message){
        super(message);
    }
}
