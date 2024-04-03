package com.doctor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class SlotsResponseDto {

    private int id;
    private String startTime;
    private String endTime;
}
