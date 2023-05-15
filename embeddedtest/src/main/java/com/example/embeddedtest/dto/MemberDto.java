package com.example.embeddedtest.dto;


import ch.qos.logback.core.joran.spi.NoAutoStart;
import lombok.*;

import javax.validation.constraints.NotNull;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@ToString
public class MemberDto {

    @NotNull
    private int num;

    @NotNull
    private String name;

    @NotNull
    private int score;


}
