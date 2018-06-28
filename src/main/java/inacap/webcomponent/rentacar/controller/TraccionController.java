/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.Repository.TraccionRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import inacap.webcomponent.rentacar.model.TraccionModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/tracciones")
public class TraccionController {
    
    @Autowired
    private TraccionRepository  traccionRespository;
    
    
    @GetMapping()
    public Iterable<TraccionModel> listarTodos() {
        
        return traccionRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TraccionModel> muestraUnaTraccion(@PathVariable String id) {
        
        Optional<TraccionModel> aOptional = traccionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TraccionModel> editaTraccion(@PathVariable String id, @RequestBody TraccionModel traccionEditar) {
        
        Optional<TraccionModel> aOptional = traccionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            TraccionModel aEncontrado = aOptional.get();
            
            traccionEditar.setIdTraccion(aEncontrado.getIdTraccion());
            
            traccionRespository.save(traccionEditar);
            
            return new ResponseEntity<>(traccionEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTraccion(@RequestBody TraccionModel nuevaTraccion) {
      
        nuevaTraccion = traccionRespository.save(nuevaTraccion);
        
        Optional<TraccionModel> aOptional = traccionRespository.findById(nuevaTraccion.getIdTraccion());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TraccionModel> aOptional = traccionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            traccionRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}
