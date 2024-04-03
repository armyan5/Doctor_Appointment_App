package com.doctor.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class RegistrationDto {

    private String name;
    private String surname;
    private String username;
    private String password;
}
