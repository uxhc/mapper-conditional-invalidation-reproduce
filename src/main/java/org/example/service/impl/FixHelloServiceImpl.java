package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.HelloDao;
import org.example.service.HelloService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

@Service
@ConditionalOnProperty(name = "fetch.type", havingValue = "FIX")
@RequiredArgsConstructor
public class FixHelloServiceImpl implements HelloService {

    private final HelloDao helloDao;

    @Override
    public String hello(Long id) {
        return helloDao.hello(id);
    }
}
