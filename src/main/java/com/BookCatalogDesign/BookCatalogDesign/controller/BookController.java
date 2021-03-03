package com.BookCatalogDesign.BookCatalogDesign.controller;

import com.BookCatalogDesign.BookCatalogDesign.bookexception.NoSucBookExistsInDb;
import com.BookCatalogDesign.BookCatalogDesign.input.BookInput;
import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import com.BookCatalogDesign.BookCatalogDesign.output.BookCategoryOutput;
import com.BookCatalogDesign.BookCatalogDesign.output.BookOutput;
import com.BookCatalogDesign.BookCatalogDesign.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/book")
@RestController
public class BookController {
    @Autowired
    BookService bookService;

    @Autowired
    ObjectMapper objectMapper;

    @PostMapping("addBookToDb")
    public String addBookToDataBase(@RequestBody BookInput bookInput){
        Book book = objectMapper.convertValue(bookInput,Book.class);
        return bookService.addBookToDb(book);
    }
    @RequestMapping(value = "getBookByBookName/{bookName}",method = RequestMethod.GET)
    public List<BookOutput> getBookByBookName(@PathVariable String bookName) throws NoSucBookExistsInDb {
        List<Book> bookDetails = bookService.searchBookInDb(bookName);
        List<BookOutput> bookOutputs = new ArrayList<>();
        bookDetails.forEach(book -> {
            bookOutputs.add(objectMapper.convertValue(book,BookOutput.class));
        });
        return bookOutputs;
    }
    @RequestMapping(value = "getListOfBookByCategory" ,method = RequestMethod.GET)
    public BookCategoryOutput[] getAllBookCategory(){
        return BookCategoryOutput.values();
    }


}
