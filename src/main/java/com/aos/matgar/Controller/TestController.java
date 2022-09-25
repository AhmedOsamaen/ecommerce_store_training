package com.aos.matgar.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("helloMatgar")
    public String helloMatgar(){
        return "Hello Mr Matgar";
    }
}
