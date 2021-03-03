package com.BookCatalogDesign.BookCatalogDesign.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Book {

    String bookName;
    UUID bookId;
    UUID authorId;
    String publisher;
    String category;
    double price;
    int soldCount;

    @Override
    public String toString() {

        return "BookInput{" +
                "bookName='" + bookName + '\'' +
                ", bookId=" + bookId +
                ", authorId=" + authorId +
                ", publisher='" + publisher + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", soldCount=" + soldCount +
                '}';
    }
}
