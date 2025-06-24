package com.example.ApiRest.mapper;

import com.example.ApiRest.dto.PersonaDto;
import com.example.ApiRest.model.Persona;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonaMapper {

    PersonaDto ToPersonaDto(Persona persona);

    Persona toPersona(PersonaDto personaDto);

    List<Persona> toPersonaList(List<PersonaDto> personaDtoList);

    List<PersonaDto> toListPersonaDtoList(List<Persona> personaList);

}
