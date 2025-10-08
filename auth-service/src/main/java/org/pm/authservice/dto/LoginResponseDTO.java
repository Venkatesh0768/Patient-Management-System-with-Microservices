package org.pm.authservice.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
public class LoginResponseDTO {
    private final  String token;

    public LoginResponseDTO(String token) {
        this.token = token;
    }
}
