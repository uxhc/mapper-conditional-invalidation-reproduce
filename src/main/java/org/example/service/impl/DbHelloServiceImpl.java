package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.mapper.HelloMapper;
import org.example.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "fetch.type", havingValue = "DB")
@RequiredArgsConstructor
public class DbHelloServiceImpl implements HelloService {

    private final HelloMapper helloMapper;

    @Override
    public String hello(Long id) {
        return helloMapper.hello(id);
    }
}
