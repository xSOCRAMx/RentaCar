/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.Repository.CombustibleRepository;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import inacap.webcomponent.rentacar.model.CombustibleModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/combustibles")
public class CombustibleController {
    
    @Autowired
    private CombustibleRepository  combustibleRespository;
    
    
    @GetMapping()
    public Iterable<CombustibleModel> listarTodos() {
        
        return combustibleRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CombustibleModel> muestraUnaCarroceria(@PathVariable String id) {
        
        Optional<CombustibleModel> aOptional = combustibleRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CombustibleModel> editaCombustible(@PathVariable String id, @RequestBody CombustibleModel combustibleEditar) {
        
        Optional<CombustibleModel> aOptional = combustibleRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            CombustibleModel aEncontrado = aOptional.get();
            
            combustibleEditar.setIdCombustible(aEncontrado.getIdCombustible());
            
            combustibleRespository.save(combustibleEditar);
            
            return new ResponseEntity<>(combustibleEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarCombustible(@RequestBody CombustibleModel nuevoCombustible) {
      
        nuevoCombustible = combustibleRespository.save(nuevoCombustible);
        
        Optional<CombustibleModel> aOptional = combustibleRespository.findById(nuevoCombustible.getIdCombustible());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CombustibleModel> aOptional = combustibleRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            combustibleRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
    
}
