package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.service.HelloService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloController {
    private final HelloService helloService;

    @GetMapping("/hello")
    public String hello(Long id) {
        return helloService.hello(id);
    }
}
