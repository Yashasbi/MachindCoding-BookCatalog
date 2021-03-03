package com.BookCatalogDesign.BookCatalogDesign.BeanClasses;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

public class ObjectMapperBean {

    @Bean
    public ObjectMapper getObjectMapperBean(){
        return new ObjectMapper();

    }
}
