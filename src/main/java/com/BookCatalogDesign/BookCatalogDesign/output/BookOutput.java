package com.BookCatalogDesign.BookCatalogDesign.output;

import com.BookCatalogDesign.BookCatalogDesign.model.BookCategory;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class BookOutput {
    String bookName;
    UUID bookId;
    UUID authorId;
    String publisher;
    BookCategory category;
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
