/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.Repository.TransmisionRepository;
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

import inacap.webcomponent.rentacar.model.TransmisionModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/transmisiones")
public class TransmisionController {
    
    @Autowired
    private TransmisionRepository  transmisionRespository;
    
    
    @GetMapping()
    public Iterable<TransmisionModel> listarTodos() {
        
        return transmisionRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<TransmisionModel> muestraUnaTransmision(@PathVariable String id) {
        
        Optional<TransmisionModel> aOptional = transmisionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<TransmisionModel> editaTransmision(@PathVariable String id, @RequestBody TransmisionModel transmisionEditar) {
        
        Optional<TransmisionModel> aOptional = transmisionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            TransmisionModel aEncontrado = aOptional.get();
            
            transmisionEditar.setIdTransmision(aEncontrado.getIdTransmision());
            
            transmisionRespository.save(transmisionEditar);
            
            return new ResponseEntity<>(transmisionEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarTransmision(@RequestBody TransmisionModel nuevaTransmision) {
      
        nuevaTransmision = transmisionRespository.save(nuevaTransmision);
        
        Optional<TransmisionModel> aOptional = transmisionRespository.findById(nuevaTransmision.getIdTransmision());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<TransmisionModel> aOptional = transmisionRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            transmisionRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    } 
}
