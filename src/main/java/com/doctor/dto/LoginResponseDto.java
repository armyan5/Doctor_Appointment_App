package com.doctor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class LoginResponseDto {

    private String accessToken;
    private String refreshToken;
    private String message;
}

