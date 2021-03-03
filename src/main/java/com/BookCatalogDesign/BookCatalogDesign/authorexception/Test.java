package com.BookCatalogDesign.BookCatalogDesign.authorexception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Test {
    String id;
    String name;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }
}
