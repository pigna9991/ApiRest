package com.example.ApiRest.service;

import com.example.ApiRest.dto.PersonaDto;
import com.example.ApiRest.mapper.PersonaMapper;
import com.example.ApiRest.model.Persona;
import com.example.ApiRest.repository.PersonaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonaService {


    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private PersonaMapper personaMapper;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    String messaggio;

    public List<String> getALl(){
        List<Persona> personaList =  personaRepository.findAll();
        List<String> messaggi= new ArrayList<>();

        for (Persona persona : personaList){
            personaMapper.ToPersonaDto(persona);
            String eta = String.valueOf(Period.between(persona.getDataNascita(), LocalDate.now()).getYears()) ;
            String dataNascita = persona.getDataNascita().format(formatter);
            messaggio = persona.getNome() + " è nato il " + dataNascita  + " ed ha " + eta + " anni.";
            messaggi.add(messaggio);
        }
        return messaggi;
    }

    public String findByCodiceFiscale (String codiceFiscale){
       Optional<Persona> personaOptional = personaRepository.findByCodiceFiscale(codiceFiscale);

       if(personaOptional.isPresent()){
           LocalDate data = personaOptional.map(Persona::getDataNascita).orElseThrow(() -> new RuntimeException("Data di nascita non trovata"));
           String nome = personaOptional.map(Persona::getNome).orElseThrow(()-> new RuntimeException("Nome non trovato"));
           String eta = String.valueOf(Period.between(data,LocalDate.now()).getYears() );
           messaggio = nome + " è nato il " + data + " ed ha " + eta + " anni.";
       }

        return  messaggio;
    }
    public List<String>  savePersonaList(List<PersonaDto> personaDtoList){
        List<Persona> personaList = personaMapper.toPersonaList(personaDtoList);
        personaRepository.saveAll(personaList);
        return  personaList.stream().map(persona -> persona.getNome() + persona.getCognome() + " é stato aggiunto").collect(Collectors.toList());
    }

}
