/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inacap.webcomponent.rentacar.controller;

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

import inacap.webcomponent.rentacar.model.TipoPersonaModel;
import org.springframework.http.HttpStatus;

/**
 *
 * @author Marcos
 */
@RestController
@RequestMapping("/tipopersonas")
public class TipoPersonaController {
    
    @Autowired
    private CarroceriaRepository  carroceriaRespository;
    
    
    @GetMapping()
    public Iterable<CarroceriaModel> listarTodos() {
        
        return carroceriaRespository.findAll();
        
    }

    
    @GetMapping("/{id}")
    public ResponseEntity<CarroceriaModel> muestraUnaCarroceria(@PathVariable String id) {
        
        Optional<CarroceriaModel> aOptional = carroceriaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.FOUND);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<CarroceriaModel> editaCarroceria(@PathVariable String id, @RequestBody CarroceriaModel carroceriaEditar) {
        
        Optional<CarroceriaModel> aOptional = carroceriaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            CarroceriaModel aEncontrado = aOptional.get();
            
            carroceriaEditar.setIdCarroceria(aEncontrado.getIdCarroceria());
            
            carroceriaRespository.save(carroceriaEditar);
            
            return new ResponseEntity<>(carroceriaEditar, HttpStatus.OK);
            
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_MODIFIED);
        }
        
    }
    
    @PostMapping
    public ResponseEntity<?> agregarCarroceria(@RequestBody CarroceriaModel nuevaCarroceria) {
      
        nuevaCarroceria = carroceriaRespository.save(nuevaCarroceria);
        
        Optional<CarroceriaModel> aOptional = carroceriaRespository.findById(nuevaCarroceria.getIdCarroceria());
        
        if(aOptional.isPresent()){
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
      
        
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        
        Optional<CarroceriaModel> aOptional = carroceriaRespository.findById(Integer.parseInt(id));
        
        if(aOptional.isPresent()){
            carroceriaRespository.deleteById(Integer.parseInt(id));
            return new ResponseEntity<>(aOptional.get(), HttpStatus.OK);
        }else{
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        
        
    }
}
