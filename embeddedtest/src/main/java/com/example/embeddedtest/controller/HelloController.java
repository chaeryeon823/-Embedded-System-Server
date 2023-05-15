package com.example.embeddedtest.controller;

import com.example.embeddedtest.dto.MemberDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/api/hello3")
    public Object Hello3(MemberDto memberDto) {
        return  memberDto.toString();
    }

    @GetMapping("api/hello4")
    public ResponseEntity<String> Hello4() {
        return new ResponseEntity<>("Start", HttpStatus.OK);
    }
}
