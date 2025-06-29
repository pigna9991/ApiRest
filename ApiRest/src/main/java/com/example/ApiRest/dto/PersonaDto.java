package com.example.ApiRest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonaDto {

    private String nome, cognome, codiceFiscale;

    private LocalDate dataNascita;

}
