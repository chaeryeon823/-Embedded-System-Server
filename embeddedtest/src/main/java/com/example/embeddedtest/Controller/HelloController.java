package com.example.embeddedtest.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

@RestController
public class HelloController {

    @GetMapping("/api/hello")
    public List<String> Hello(){
        return Arrays.asList("연결이 ", "되었습니다!");
    }

    @GetMapping("/api/hello2")
    public String Hello2() {
        return "모시깽이";
    }
}
