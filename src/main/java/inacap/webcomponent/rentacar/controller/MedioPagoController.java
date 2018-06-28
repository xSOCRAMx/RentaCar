/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

import inacap.webcomponent.rentacar.Repository.MedioPagoRepository;
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

import inacap.webcomponent.rentacar.model.MedioPagoModel;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/mediospago")
public class MedioPagoController {
    
    @Autowired
    private MedioPagoRepository  mediopagoRespository;
    
    
    @GetMapping()
    public Iterable<MedioPagoModel> listarTodos() {
        
        return mediopagoRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<MedioPagoModel> muestraUnMedioPago(@PathVariable String id) {
        
        Optional<MedioPagoModel> aOptional = mediopagoRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<MedioPagoModel> editaMedioPago(@PathVariable String id, @RequestBody MedioPagoModel mediopagoEditar) {
        
        Optional<MedioPagoModel> aOptional = mediopagoRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            MedioPagoModel aEncontrado = aOptional.get();
            
            mediopagoEditar.setIdMedioPago(aEncontrado.getIdMedioPago());
            
            mediopagoRespository.save(mediopagoEditar);
            
            return new ResponseEntity<>(mediopagoEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarMedioPago(@RequestBody MedioPagoModel nuevaCarroceria) {
      
        nuevaCarroceria = mediopagoRespository.save(nuevaCarroceria);
        
        Optional<MedioPagoModel> aOptional = mediopagoRespository.findById(nuevaCarroceria.getIdMedioPago());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<MedioPagoModel> aOptional = mediopagoRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            mediopagoRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}
