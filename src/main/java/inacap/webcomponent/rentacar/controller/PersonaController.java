/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.model.PersonaModel;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/personas")
public class PersonaController {
    
   @GetMapping()
    public List<PersonaModel> list() {
        return PersonaModel.personas;
    }
    
    @GetMapping("/{id}")
    public PersonaModel get(@PathVariable String id) {
        PersonaModel persona = new PersonaModel();
        return persona.buscarPersona(Integer.parseInt(id));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody PersonaModel personaEditar) {
        PersonaModel persona = new PersonaModel();
        persona.editarPersona(Integer.parseInt(id), personaEditar);
        return new ResponseEntity<>(persona.editarPersona(Integer.parseInt(id), personaEditar), HttpStatus.OK);
    }
    
    @PostMapping
    public ResponseEntity<?> post(@RequestBody PersonaModel nuevaPersona) {
        PersonaModel persona = new PersonaModel();
        if (persona.nuevaPersona(nuevaPersona)) {
            return new ResponseEntity<>(HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_ACCEPTABLE);
        }

    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        PersonaModel persona = new PersonaModel();
        if (persona.eliminarPersona(Integer.parseInt(id))) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
        }
    }
}
