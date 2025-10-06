package org.pm.patientservice.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.pm.patientservice.dtos.validators.CreatePatientValidationGroup;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {

    @NotBlank
    @Size(max = 100, message = "Name Should not be exceed the 100 Characters")
    private String name;

    @NotBlank(message = "Email Should not be Empty")
    @Email(message = "Email is Required")
    private String email;

    @NotBlank(message = "Address should not be empty")
    private String address;


    @NotBlank(message = "Date of Birth is required")
    private String dateOfBirth;


    @NotBlank( groups = CreatePatientValidationGroup.class , message = "Registered date is required")
    private String registeredDate;

}
