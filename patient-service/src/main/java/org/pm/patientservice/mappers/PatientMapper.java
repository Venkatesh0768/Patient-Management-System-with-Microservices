package org.pm.patientservice.mappers;

import org.pm.patientservice.dtos.PatientRequestDTO;
import org.pm.patientservice.dtos.PatientResponseDTO;
import org.pm.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDTO toDTO(Patient patient){
        return PatientResponseDTO.builder()
                .id(patient.getId().toString())
                .address(patient.getAddress())
                .email(patient.getEmail())
                .name(patient.getName())
                .dateOfBirth(patient.getDateOfBirth().toString())
                .build();
    }

    public static Patient toModel(PatientRequestDTO patientRequestDTO){
        return Patient.builder()
                .name(patientRequestDTO.getName())
                .email(patientRequestDTO.getEmail())
                .address(patientRequestDTO.getAddress())
                .dateOfBirth(LocalDate.parse(patientRequestDTO.getDateOfBirth()))
                .registeredDate(LocalDate.parse(patientRequestDTO.getRegisteredDate()))
                .build();
    }

}
