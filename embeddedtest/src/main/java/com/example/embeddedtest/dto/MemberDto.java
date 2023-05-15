package com.example.embeddedtest.dto;


import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@ToString
public class MemberDto {

    @NotNull
    private long num;

    @NotNull
    private String name;

    @NotNull
    private int score;

    public static MemberDto from(long num, String name, int score) {
        return new MemberDto(num, name, score);
    }

}
