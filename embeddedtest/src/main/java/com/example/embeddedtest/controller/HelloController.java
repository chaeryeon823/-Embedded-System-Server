package com.example.embeddedtest.controller;

import com.example.embeddedtest.dto.MemberDto;
import com.example.embeddedtest.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class HelloController {
    public final MemberService memberService;

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

    /**
     * map 초기화... 어케 할 지 몰라서 따로 api 만듦...
     * @return
     */
    @GetMapping("/api/hello4")
    public ResponseEntity<String> Hello4() {
        memberService.init();
        return new ResponseEntity<>("Start", HttpStatus.OK);
    }

    /**
     * 사용자 추가
     * @param map
     * @return
     */
    @PostMapping("/api/hello5")
    public ResponseEntity Hello5(@RequestBody LinkedHashMap map) {

        memberService.join(map.get("name").toString());

        return new ResponseEntity(HttpStatus.OK);
    }

    @GetMapping("/api/hello6")
    public ResponseEntity<List<MemberDto>> Hello6() {
        return new ResponseEntity<>(memberService.findTop10List(), HttpStatus.OK);
    }

    @PostMapping("/api/hello7")
    public String Hello7(@RequestBody String name) {
        System.out.println(name);
        return "성공";
    }
}


