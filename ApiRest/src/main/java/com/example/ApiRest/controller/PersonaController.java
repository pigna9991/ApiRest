package com.example.ApiRest.controller;

import com.example.ApiRest.dto.PersonaDto;
import com.example.ApiRest.service.PersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persone")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    //metodo che restituisce tutte le eprsone nel database
    @GetMapping("/getPersonas")
    public ResponseEntity<List<String>> getAll() {
        List<String> listaPersone = personaService.getALl();
        if (listaPersone.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(listaPersone);
    }

    //metodo ceh restituisce solamente una persona in abse al codice fiscale
    @GetMapping("/getPersona/{codiceFiscale}")
    public ResponseEntity<String> findByCodiceFiscale(@PathVariable String codiceFiscale) {

        if (codiceFiscale == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(personaService.findByCodiceFiscale(codiceFiscale));
    }

    //metodo per inserire una o più persone
    @PostMapping("/save")
    public ResponseEntity<?> savePersonaList(@RequestBody List<PersonaDto> personaDtoList){
        if(personaDtoList.isEmpty()){
            return ResponseEntity.badRequest().body("Persona non valida");
        }
        List<String> savedPersonaList =  personaService.savePersonaList(personaDtoList);
        return ResponseEntity.ok(savedPersonaList);
    }

}
