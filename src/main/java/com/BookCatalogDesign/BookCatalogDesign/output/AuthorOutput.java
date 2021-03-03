package com.BookCatalogDesign.BookCatalogDesign.output;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class AuthorOutput {
    UUID authorId;
    String authorName;
    long phoneNumber;
    LocalDate dateOfBirth;
    LocalDate dateOfDeath;

}
