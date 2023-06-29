package com.davethino.fake.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDto {

    private String name;
    private String lastName;
    private String username;

    private String password;
    private String email;

}
