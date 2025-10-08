package org.pm.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class LoginRequestDTO {
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid Email address")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 8 , message = "Password must be aleat 8 character long")
    private String password;
}
