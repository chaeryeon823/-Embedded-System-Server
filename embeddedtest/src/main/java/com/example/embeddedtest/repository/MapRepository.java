package com.example.embeddedtest.repository;

import com.example.embeddedtest.dto.MemberDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Repository
public class MapRepository {
    private static final Map<Long, MemberDto> map = new ConcurrentHashMap<>();
    private static final Map<Long, Integer> scores = new ConcurrentHashMap<>();
    private static long sequence = 0L;

    public void save(MemberDto memberDto) {
        memberDto.setNum(++sequence);
        map.put(memberDto.getNum(), memberDto);
        scores.put(memberDto.getNum(), memberDto.getScore());
        log.info("회원가입완료={}", memberDto.getNum());
    }

    public Optional<MemberDto> findByNum(long num) {
        return Optional.ofNullable(map.get(num));
    }

    public List<MemberDto> findAllDesc() {
        List<Long> list = sortMapByValue(scores);
        int n = list.size() > 10 ? 10 : list.size();

        List<MemberDto> memberDtos = new LinkedList<>();
        for(int i = 0; i < n; i++) {
            memberDtos.add(map.get(list.get(i)));
        }

        return memberDtos;
    }

    private static List<Long> sortMapByValue(Map<Long, Integer> map) {
        List<Map.Entry<Long, Integer>> entries = new LinkedList<>(map.entrySet());
        Collections.sort(entries, (o1, o2) -> o1.getValue().compareTo(o2.getValue()));

        List<Long> result = new LinkedList<>();

        for (Map.Entry<Long, Integer> entry : entries)
            result.add(entry.getKey());

        return result;
    }
}
