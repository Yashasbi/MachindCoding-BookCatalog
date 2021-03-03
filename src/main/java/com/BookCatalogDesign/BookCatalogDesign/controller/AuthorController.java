package com.BookCatalogDesign.BookCatalogDesign.controller;
import com.BookCatalogDesign.BookCatalogDesign.bookexception.NoSucBookExistsInDb;
import com.BookCatalogDesign.BookCatalogDesign.input.AuthorInput;
import com.BookCatalogDesign.BookCatalogDesign.model.Author;
import com.BookCatalogDesign.BookCatalogDesign.model.Book;
import com.BookCatalogDesign.BookCatalogDesign.output.AuthorOutput;
import com.BookCatalogDesign.BookCatalogDesign.output.BookOutput;
import com.BookCatalogDesign.BookCatalogDesign.service.AuthorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/v1/author")
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @Autowired
    ObjectMapper objectMapper;

    @PostMapping ("addAuthorToDb")
    public String addAuthorToDb(@RequestBody AuthorInput authorInput){
        Author author = new Author(authorInput.getAuthorId(),authorInput.getAuthorName(),authorInput.getPhoneNumber(), LocalDate.parse(authorInput.getDateOfBirth()),LocalDate.parse(authorInput.getDateOfDeath()));
        return authorService.addAuthorToDb(author);
    }
    @GetMapping("/getAllAuthor")
    public List<AuthorOutput> getAllAuthorDetails(){
        List<AuthorOutput> outputList = new ArrayList<>();
        List<Author> authorList = authorService.getAllAuthorDetails();
        authorList.forEach(author -> outputList.add(objectMapper.convertValue(author,AuthorOutput.class)));
        return outputList;
    }
    @RequestMapping(value= "searchBookByAuthorName/{authorName}",method = RequestMethod.GET)
    public List<BookOutput> searchBookByAuthorName(@PathVariable String authorName) throws NoSucBookExistsInDb {
        List<BookOutput> bookOutput = new ArrayList<>();
        List<Book> bookList = authorService.searchBookByAuthorName(authorName);
        bookList.forEach(book -> bookOutput.add(objectMapper.convertValue(book,BookOutput.class)));
        return bookOutput;
    }
//    @RequestMapping(value = "getMostSoldBooks/{authorName}",method = RequestMethod.GET)
//    public List<Book> getMostSoldBooks(@PathVariable String authorName){
//
//    }
}
