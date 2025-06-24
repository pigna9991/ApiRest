package com.example.ApiRest.mapper;

import com.example.ApiRest.dto.PersonaDto;
import com.example.ApiRest.model.Persona;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-24T12:34:36+0200",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.14 (Amazon.com Inc.)"
)
@Component
public class PersonaMapperImpl implements PersonaMapper {

    @Override
    public PersonaDto ToPersonaDto(Persona persona) {
        if ( persona == null ) {
            return null;
        }

        PersonaDto personaDto = new PersonaDto();

        personaDto.setNome( persona.getNome() );
        personaDto.setCognome( persona.getCognome() );
        personaDto.setCodiceFiscale( persona.getCodiceFiscale() );
        personaDto.setDataNascita( persona.getDataNascita() );

        return personaDto;
    }

    @Override
    public Persona toPersona(PersonaDto personaDto) {
        if ( personaDto == null ) {
            return null;
        }

        Persona persona = new Persona();

        persona.setCodiceFiscale( personaDto.getCodiceFiscale() );
        persona.setDataNascita( personaDto.getDataNascita() );
        persona.setNome( personaDto.getNome() );
        persona.setCognome( personaDto.getCognome() );

        return persona;
    }

    @Override
    public List<Persona> toPersonaList(List<PersonaDto> personaDtoList) {
        if ( personaDtoList == null ) {
            return null;
        }

        List<Persona> list = new ArrayList<Persona>( personaDtoList.size() );
        for ( PersonaDto personaDto : personaDtoList ) {
            list.add( toPersona( personaDto ) );
        }

        return list;
    }

    @Override
    public List<PersonaDto> toListPersonaDtoList(List<Persona> personaList) {
        if ( personaList == null ) {
            return null;
        }

        List<PersonaDto> list = new ArrayList<PersonaDto>( personaList.size() );
        for ( Persona persona : personaList ) {
            list.add( ToPersonaDto( persona ) );
        }

        return list;
    }
}
