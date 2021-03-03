package com.BookCatalogDesign.BookCatalogDesign.input;

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

public class AuthorInput {
        UUID authorId;
        String authorName;
        long phoneNumber;
        String dateOfBirth;
        String dateOfDeath;

    @Override
    public String toString() {
        return "AuthorInput{" +
                "authorId=" + authorId +
                ", authorName='" + authorName + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", dateOfDeath='" + dateOfDeath + '\'' +
                '}';
    }
}
