package com.example.ApiRest.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "persona")
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(name="codice_fiscale", nullable = false, length = 16)
    private String codiceFiscale;

    @Column(name="data_nascita" ,nullable = false)
    private LocalDate dataNascita;

    @Column(name="nome", nullable = false, length = 50)
    private String nome;

    @Column(name="cognome", nullable = false, length = 50)
    private String cognome;


}
