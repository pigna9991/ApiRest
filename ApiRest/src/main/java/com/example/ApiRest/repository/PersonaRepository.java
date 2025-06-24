package com.example.ApiRest.repository;

import com.example.ApiRest.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long > {

    //query personalizzata per poter estrarre la persona in base al codice fiscale
    @Query(value = "SELECT *  FROM persona p WHERE p.CODICE_FISCALE = :codiceFiscale", nativeQuery = true)
    Optional<Persona> findByCodiceFiscale(@Param("codiceFiscale") String codiceFiscale);


}
