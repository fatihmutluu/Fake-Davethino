package com.davethino.fake.dto.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginDto {
    
    private String emailOrUsername;
    private String password;

}
