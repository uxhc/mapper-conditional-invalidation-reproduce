package org.example.mapper;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;

@ConditionalOnProperty(name = "fetch.type", havingValue = "DB")
public interface HelloMapper {

    String hello(Long id);
}
