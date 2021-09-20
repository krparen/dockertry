package com.example.dockertry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dummy")
@Slf4j
public class DummyController {

    @GetMapping
    public String get() {
        log.info("request has come");
        return "Hi from dummy get!";
    }
}
