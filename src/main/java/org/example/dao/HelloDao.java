package org.example.dao;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Repository;

@ConditionalOnProperty(name = "fetch.type", havingValue = "FIX")
@Repository
public class HelloDao {
    public String hello(Long id) {
        return "hello" + id;
    }
}
