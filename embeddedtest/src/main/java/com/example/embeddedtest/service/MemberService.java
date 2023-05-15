package com.example.embeddedtest.service;

import com.example.embeddedtest.dto.MemberDto;
import com.example.embeddedtest.repository.MapRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MapRepository mapRepository;

    public void init() {
        mapRepository.save(MemberDto.from(0, "apple", 99));
        mapRepository.save(MemberDto.from(0, "banana", 98));
        mapRepository.save(MemberDto.from(0, "cherry", 97));
        mapRepository.save(MemberDto.from(0, "durian", 96));
        mapRepository.save(MemberDto.from(0, "potato", 95));
    }

    public List<MemberDto> findTop10List() {
        return mapRepository.findAllDesc();
    }

    public void join(String name) {
        mapRepository.save(MemberDto.from(0, name, 0));
    }
}
